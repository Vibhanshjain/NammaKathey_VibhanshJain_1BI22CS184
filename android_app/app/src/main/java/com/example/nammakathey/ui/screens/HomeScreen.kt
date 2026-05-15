package com.example.nammakathey.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.AutoStories
import androidx.compose.material.icons.outlined.Map
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Quiz
import androidx.compose.material.icons.outlined.WorkspacePremium
import androidx.compose.material3.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.nammakathey.data.DataProvider
import com.example.nammakathey.ui.theme.BrandBrown
import com.example.nammakathey.ui.theme.BrandGreen
import com.example.nammakathey.ui.theme.BrandOrange
import com.example.nammakathey.viewmodel.AppViewModel

@Composable
fun HomeScreen(
    viewModel: AppViewModel,
    onOpenMenu: () -> Unit,
    onNavigateToStory: (String) -> Unit,
    onNavigateToStories: () -> Unit,
    onNavigateToQuiz: () -> Unit,
    onNavigateToBadges: () -> Unit,
    onNavigateToMap: () -> Unit,
    onNavigateToNotifications: () -> Unit
) {
    val language by viewModel.language.collectAsState()
    val readStories by viewModel.readStories.collectAsState()
    val completedQuizzes by viewModel.completedQuizzes.collectAsState()
    val heroes = DataProvider.heroes
    val featured = heroes.firstOrNull()
    val continueReadingHeroes = heroes.filter { readStories.contains(it.id) && !completedQuizzes.contains(it.id) }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            @OptIn(ExperimentalMaterial3Api::class)
            TopAppBar(
                title = {
                    Text(
                        text = if (language == "en") "Namma Kathey" else "ನಮ್ಮ ಕಥೆ",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = BrandBrown
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onOpenMenu) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu", tint = BrandBrown)
                    }
                },
                actions = {
                    TextButton(onClick = { viewModel.toggleLanguage() }) {
                        Text(if (language == "en") "ಕನ್ನಡ" else "English", color = BrandOrange, fontWeight = FontWeight.Bold)
                    }
                    IconButton(onClick = onNavigateToNotifications) {
                        Icon(imageVector = Icons.Outlined.Notifications, contentDescription = "Notifications", tint = BrandBrown)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    scrolledContainerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            if (featured != null) {
                item {
                    FeaturedStoryCard(
                        language = language,
                        title = if (language == "en") featured.nameEn else featured.nameKn,
                        snippet = if (language == "en") featured.storyPages.firstOrNull()?.textEn.orEmpty() else featured.storyPages.firstOrNull()?.textKn.orEmpty(),
                        imageUrl = featured.mascotUrl,
                        onClick = { onNavigateToStory(featured.id) }
                    )
                }
            }

            item {
                Text(
                    text = if (language == "en") "Explore" else "ಅನ್ವೇಷಿಸಿ",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold, color = BrandBrown)
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ExploreItem(title = if (language == "en") "Stories" else "ಕಥೆಗಳು", color = BrandGreen, icon = Icons.Outlined.AutoStories, onClick = onNavigateToStories)
                    ExploreItem(title = if (language == "en") "Quiz" else "ರಸಪ್ರಶ್ನೆ", color = Color(0xFF6B4B3A), icon = Icons.Outlined.Quiz, onClick = onNavigateToQuiz)
                    ExploreItem(title = if (language == "en") "Badges" else "ಬ್ಯಾಡ್ಜ್", color = BrandOrange, icon = Icons.Outlined.WorkspacePremium, onClick = onNavigateToBadges)
                    ExploreItem(title = if (language == "en") "Map" else "ನಕ್ಷೆ", color = Color(0xFF4A90E2), icon = Icons.Outlined.Map, onClick = onNavigateToMap)
                }
            }

            if (continueReadingHeroes.isNotEmpty()) {
                item {
                    Text(
                        text = if (language == "en") "Continue Reading" else "ಮುಂದುವರಿಸಿ",
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold, color = BrandBrown)
                    )
                }

                items(continueReadingHeroes) { hero ->
                    ContinueReadingCard(
                        title = if (language == "en") hero.nameEn else hero.nameKn,
                        subtitle = if (language == "en") hero.titleEn else hero.titleKn,
                        imageUrl = hero.mascotUrl,
                        onClick = { onNavigateToStory(hero.id) }
                    )
                }
            }
            
            item { Spacer(modifier = Modifier.height(80.dp)) }
        }
    }
}

@Composable
fun FeaturedStoryCard(
    language: String,
    title: String,
    snippet: String,
    imageUrl: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = BrandOrange)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.4f)
                    .clip(RoundedCornerShape(topStart = 24.dp, bottomStart = 24.dp))
                    .align(Alignment.CenterEnd),
                alpha = 0.9f
            )
            // Gradient or solid overlay could go here
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.65f)
                    .background(BrandOrange.copy(alpha = 0.9f))
                    .padding(20.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = if (language == "en") "Today's Story" else "ಇಂದಿನ ಕಥೆ",
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = title,
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    lineHeight = 24.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = snippet,
                    color = Color.White.copy(alpha = 0.9f),
                    fontSize = 12.sp,
                    maxLines = 2,
                    modifier = Modifier.padding(bottom = 12.dp)
                )
                Button(
                    onClick = onClick,
                    colors = ButtonDefaults.buttonColors(containerColor = BrandBrown),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp),
                    modifier = Modifier.height(32.dp)
                ) {
                    Text(if (language == "en") "Read Now" else "ಈಗ ಓದಿ", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
fun ExploreItem(title: String, color: Color, icon: ImageVector, onClick: () -> Unit) {
    Column(
        modifier = Modifier.clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(color),
            contentAlignment = Alignment.Center
        ) {
            Icon(imageVector = icon, contentDescription = title, tint = Color.White, modifier = Modifier.size(32.dp))
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = title, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = BrandBrown)
    }
}

@Composable
fun ContinueReadingCard(title: String, subtitle: String, imageUrl: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(12.dp))
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = title, fontWeight = FontWeight.Bold, color = BrandBrown)
                Text(text = subtitle, fontSize = 12.sp, color = Color.Gray)
                Spacer(modifier = Modifier.height(8.dp))
                // Progress bar
                LinearProgressIndicator(
                    progress = 0.45f,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(6.dp)
                        .clip(RoundedCornerShape(3.dp)),
                    color = BrandGreen,
                    trackColor = Color(0xFFF2E8D5)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text("›", fontSize = 24.sp, color = BrandBrown, fontWeight = FontWeight.Bold)
        }
    }
}

