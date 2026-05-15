package com.example.nammakathey.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.nammakathey.data.DataProvider
import com.example.nammakathey.viewmodel.AppViewModel
import kotlinx.coroutines.launch

import coil.compose.AsyncImage
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.draw.clip
import com.example.nammakathey.ui.theme.BrandBrown

import androidx.compose.ui.platform.LocalContext
import android.speech.tts.TextToSpeech
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material.icons.filled.Speed
import java.util.Locale

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun StoryReaderScreen(
    heroId: String,
    viewModel: AppViewModel,
    onNavigateBack: () -> Unit,
    onNavigateToQuiz: (String) -> Unit
) {
    val language by viewModel.language.collectAsState()
    val savedIds by viewModel.savedStories.collectAsState()
    val isSaved = savedIds.contains(heroId)
    val hero = DataProvider.heroes.find { it.id == heroId } ?: return
    
    LaunchedEffect(heroId) {
        viewModel.markStoryRead(heroId)
    }
    
    val pagerState = rememberPagerState(pageCount = { hero.storyPages.size })
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    
    var tts by remember { mutableStateOf<TextToSpeech?>(null) }
    var isPlaying by remember { mutableStateOf(false) }
    val ttsSpeed by viewModel.ttsSpeed.collectAsState()
    
    DisposableEffect(context) {
        val textToSpeech = TextToSpeech(context) { status -> }
        tts = textToSpeech
        onDispose {
            textToSpeech.stop()
            textToSpeech.shutdown()
        }
    }
    
    val currentText = if (language == "en") hero.storyPages[pagerState.currentPage].textEn else hero.storyPages[pagerState.currentPage].textKn

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (language == "en") hero.nameEn else hero.nameKn, color = BrandBrown, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background),
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = BrandBrown)
                    }
                },
                actions = {
                    IconButton(onClick = { 
                        val newSpeed = if (ttsSpeed >= 2.0f) 1.0f
                        else if (ttsSpeed >= 1.5f) 2.0f
                        else 1.5f
                        
                        viewModel.setTtsSpeed(newSpeed)
                        tts?.setSpeechRate(newSpeed)
                        
                        if (isPlaying) {
                            tts?.stop()
                            tts?.setLanguage(if (language == "kn") Locale("kn", "IN") else Locale.US)
                            tts?.speak(currentText, TextToSpeech.QUEUE_FLUSH, null, null)
                        }
                    }) {
                        Text("${ttsSpeed}x", fontWeight = androidx.compose.ui.text.font.FontWeight.Bold, color = BrandBrown)
                    }
                    IconButton(onClick = { 
                        if (isPlaying) {
                            tts?.stop()
                            isPlaying = false
                        } else {
                            tts?.setSpeechRate(ttsSpeed)
                            tts?.setLanguage(if (language == "kn") Locale("kn", "IN") else Locale.US)
                            tts?.speak(currentText, TextToSpeech.QUEUE_FLUSH, null, null)
                            isPlaying = true
                        }
                    }) {
                        Icon(if (isPlaying) Icons.Default.Stop else Icons.Default.PlayArrow, contentDescription = "TTS", tint = BrandBrown)
                    }
                    IconButton(onClick = { viewModel.toggleSavedStory(heroId) }) {
                        Icon(if (isSaved) Icons.Default.Bookmark else Icons.Outlined.BookmarkBorder, contentDescription = "Save", tint = BrandBrown)
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.weight(1f)
            ) { page ->
                val storyPage = hero.storyPages[page]
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(
                        text = if (language == "en") storyPage.textEn else storyPage.textKn,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }

            // Bottom Navigation Controls
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage - 1)
                        }
                    },
                    enabled = pagerState.currentPage > 0
                ) {
                    Text(if (language == "en") "Previous" else "ಹಿಂದೆ")
                }

                Text("${pagerState.currentPage + 1} / ${hero.storyPages.size}")

                if (pagerState.currentPage < hero.storyPages.size - 1) {
                    Button(
                        onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            }
                        }
                    ) {
                        Text(if (language == "en") "Next" else "ಮುಂದೆ")
                    }
                } else {
                    Button(
                        onClick = { onNavigateToQuiz(hero.id) },
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                    ) {
                        Text(if (language == "en") "Quiz" else "ರಸಪ್ರಶ್ನೆ")
                    }
                }
            }
        }
    }
}
