package com.example.nammakathey.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nammakathey.data.DataProvider
import com.example.nammakathey.viewmodel.AppViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizScreen(
    heroId: String,
    viewModel: AppViewModel,
    onNavigateBack: () -> Unit,
    onNavigateHome: () -> Unit
) {
    val language by viewModel.language.collectAsState()
    val hero = DataProvider.heroes.find { it.id == heroId } ?: return

    if (hero.quiz.isEmpty()) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text("No quiz available for this hero.")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onNavigateBack) { Text("Back") }
        }
        return
    }

    var currentQIndex by remember { mutableStateOf(0) }
    var selectedOpt by remember { mutableStateOf<Int?>(null) }
    var isAnswered by remember { mutableStateOf(false) }
    var score by remember { mutableStateOf(0) }
    var isComplete by remember { mutableStateOf(false) }

    val question = hero.quiz[currentQIndex]
    val options = if (language == "en") question.optionsEn else question.optionsKn

    if (isComplete) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = if (language == "en") "Quiz Complete!" else "ರಸಪ್ರಶ್ನೆ ಪೂರ್ಣಗೊಂಡಿದೆ!",
                style = MaterialTheme.typography.headlineLarge
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "${if (language == "en") "Score:" else "ಅಂಕಗಳು:"} $score / ${hero.quiz.size}",
                style = MaterialTheme.typography.headlineMedium
            )
            if (score == hero.quiz.size) {
                Text(
                    text = if (language == "en") "You earned a badge!" else "ನೀವು ಬ್ಯಾಡ್ಜ್ ಗಳಿಸಿದ್ದೀರಿ!",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            } else {
                Text(
                    text = if (language == "en") "Answer all questions correctly to earn a badge." else "ಬ್ಯಾಡ್ಜ್ ಗಳಿಸಲು ಎಲ್ಲಾ ಪ್ರಶ್ನೆಗಳಿಗೆ ಸರಿಯಾಗಿ ಉತ್ತರಿಸಿ.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.error
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
            Button(onClick = onNavigateHome) {
                Text(if (language == "en") "Back to Home" else "ಮುಖಪುಟಕ್ಕೆ ಹಿಂತಿರುಗಿ")
            }
        }
        return
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (language == "en") "Quiz Time!" else "ರಸಪ್ರಶ್ನೆ") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(24.dp)
                .fillMaxSize()
        ) {
            Text(
                text = "${currentQIndex + 1} / ${hero.quiz.size}",
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier.align(Alignment.End)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = if (language == "en") question.questionEn else question.questionKn,
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(32.dp))

            options.forEachIndexed { index, opt ->
                Button(
                    onClick = {
                        if (!isAnswered) {
                            selectedOpt = index
                            isAnswered = true
                            if (index == question.correctIndex) {
                                score++
                            }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    enabled = !isAnswered || selectedOpt == index,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isAnswered && index == question.correctIndex) MaterialTheme.colorScheme.primary
                        else if (isAnswered && selectedOpt == index) MaterialTheme.colorScheme.error
                        else MaterialTheme.colorScheme.surfaceVariant,
                        contentColor = MaterialTheme.colorScheme.onSurface
                    )
                ) {
                    Text(
                        text = "${(65 + index).toChar()}. $opt",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }
            }

            if (isAnswered) {
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = {
                        if (currentQIndex < hero.quiz.size - 1) {
                            currentQIndex++
                            isAnswered = false
                            selectedOpt = null
                        } else {
                            if (score == hero.quiz.size) {
                                viewModel.markQuizCompleted(heroId)
                            }
                            isComplete = true
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(if (language == "en") "Next" else "ಮುಂದೆ")
                }
            }
        }
    }
}
