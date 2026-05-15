package com.example.nammakathey.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nammakathey.data.DataProvider
import com.example.nammakathey.ui.theme.BrandBrown
import com.example.nammakathey.ui.theme.BrandGreen
import com.example.nammakathey.ui.theme.BrandOrange
import com.example.nammakathey.viewmodel.AppViewModel
import coil.compose.AsyncImage
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.HeadsetMic
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.ChevronLeft

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutUsScreen(onNavigateBack: () -> Unit = {}) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("About Us", fontWeight = FontWeight.Bold, color = BrandBrown) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        androidx.compose.material3.Icon(Icons.Default.ChevronLeft, contentDescription = "Back", tint = BrandBrown)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.fillMaxSize().padding(paddingValues).padding(16.dp).verticalScroll(rememberScrollState())) {
            Text("Namma Kathey", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = BrandBrown)
            Spacer(modifier = Modifier.height(16.dp))
            Text("Namma Kathey is an educational and cultural storytelling application designed to help children and young learners discover the inspiring heroes, legends, and historical figures of Karnataka. In today’s world, many children know international superheroes but are unaware of the brave personalities and rich history from their own districts.", fontSize = 16.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Text("Our app aims to preserve and promote local culture through interactive stories, quizzes, achievements, and gamified learning. By combining technology with regional history, Namma Kathey makes learning fun, engaging, and accessible even without internet connectivity.", fontSize = 16.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Text("The mission of Namma Kathey is to create awareness about Karnataka’s heritage, inspire patriotism and courage among students, and ensure that the stories of our local heroes continue to live on in future generations.", fontSize = 16.sp)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HelpSupportScreen(onNavigateBack: () -> Unit = {}) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Help & Support", fontWeight = FontWeight.Bold, color = BrandBrown) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        androidx.compose.material3.Icon(Icons.Default.ChevronLeft, contentDescription = "Back", tint = BrandBrown)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.fillMaxSize().padding(paddingValues).padding(16.dp).verticalScroll(rememberScrollState())) {
            Text("Welcome Message", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = BrandBrown)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Welcome to Namma Kathey!", fontWeight = FontWeight.Bold)
            Text("We are happy to help you enjoy learning about Karnataka’s heroes and legends. If you face any issues while using the app, this section will guide you.")
            
            Spacer(modifier = Modifier.height(16.dp))
            Text("How to Use the App", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = BrandBrown)
            Spacer(modifier = Modifier.height(8.dp))
            Text("1. Open the app and select your district or hero story.\n2. Read or listen to inspiring stories of Karnataka legends.\n3. Attempt quizzes after completing each story.\n4. Earn points, badges, or achievements through learning activities.\n5. Use the offline mode to access stories without internet.")

            Spacer(modifier = Modifier.height(16.dp))
            Text("Frequently Asked Questions (FAQs)", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = BrandBrown)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Q: Can I use the app without internet?", fontWeight = FontWeight.Bold)
            Text("A: Yes, most stories and quizzes are available offline after installation.")
            Spacer(modifier = Modifier.height(4.dp))
            Text("Q: Is the app free to use?", fontWeight = FontWeight.Bold)
            Text("A: Yes, Namma Kathey is free for educational purposes.")
            Spacer(modifier = Modifier.height(4.dp))
            Text("Q: Which languages are supported?", fontWeight = FontWeight.Bold)
            Text("A: The app supports Kannada and English.")
            Spacer(modifier = Modifier.height(4.dp))
            Text("Q: Who can use this app?", fontWeight = FontWeight.Bold)
            Text("A: The app is designed mainly for children and students, but anyone interested in Karnataka’s history can use it.")
            Spacer(modifier = Modifier.height(4.dp))
            Text("Q: Why are some stories not loading?", fontWeight = FontWeight.Bold)
            Text("A: Please restart the app or check if the content has been downloaded properly.")

            Spacer(modifier = Modifier.height(16.dp))
            Text("Troubleshooting", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = BrandBrown)
            Spacer(modifier = Modifier.height(8.dp))
            Text("App not opening", fontWeight = FontWeight.Bold)
            Text("• Restart your mobile device.\n• Update the app to the latest version.\n• Clear app cache if required.")
            Spacer(modifier = Modifier.height(8.dp))
            Text("Audio not working", fontWeight = FontWeight.Bold)
            Text("• Check your device volume settings.\n• Ensure audio permissions are enabled.")
            Spacer(modifier = Modifier.height(8.dp))
            Text("Quiz not submitting", fontWeight = FontWeight.Bold)
            Text("• Reopen the quiz page and try again.")

            Spacer(modifier = Modifier.height(16.dp))
            Text("Contact Support", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = BrandBrown)
            Spacer(modifier = Modifier.height(8.dp))
            Text("If you still face any issues or want to suggest improvements, contact us:")
            Text("📧 Email: support@nammakathey.com")
            Text("📱 Phone: +91 99831 90331")
            
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeedbackScreen() {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var feedback by remember { mutableStateOf("") }
    var submitted by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Feedback", fontWeight = FontWeight.Bold, color = BrandBrown) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.fillMaxSize().padding(paddingValues).padding(16.dp)) {
            if (submitted) {
                Text("Thank you for your feedback!", fontSize = 20.sp, color = BrandGreen, fontWeight = FontWeight.Bold)
            } else {
                OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("Name") }, modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(value = email, onValueChange = { email = it }, label = { Text("Email") }, modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(value = feedback, onValueChange = { feedback = it }, label = { Text("Feedback") }, modifier = Modifier.fillMaxWidth().height(150.dp), maxLines = 5)
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { submitted = true }, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(containerColor = BrandBrown)) {
                    Text("Submit Feedback", color = Color.White)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationsScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Notifications", fontWeight = FontWeight.Bold, color = BrandBrown) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
            )
        }
    ) { paddingValues ->
        LazyColumn(contentPadding = paddingValues, modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            item {
                Card(modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(containerColor = BrandOrange.copy(alpha = 0.2f))) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Welcome to Namma Kathey!", fontWeight = FontWeight.Bold)
                        Text("Explore stories of heroes from Karnataka.")
                    }
                }
            }
            item {
                Card(modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(containerColor = BrandGreen.copy(alpha = 0.2f))) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("New Quiz Available", fontWeight = FontWeight.Bold)
                        Text("Test your knowledge on Sangolli Rayanna.")
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SavedScreen(viewModel: AppViewModel, onNavigateToStory: (String) -> Unit) {
    val savedIds by viewModel.savedStories.collectAsState()
    val language by viewModel.language.collectAsState()
    val savedHeroes = DataProvider.heroes.filter { savedIds.contains(it.id) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (language == "en") "Saved Stories" else "ಉಳಿಸಿದ ಕಥೆಗಳು", fontWeight = FontWeight.Bold, color = BrandBrown) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
            )
        }
    ) { paddingValues ->
        LazyColumn(contentPadding = paddingValues, modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            if (savedHeroes.isEmpty()) {
                item { Text("No saved stories yet.", color = Color.Gray) }
            }
            items(savedHeroes) { hero ->
                Card(
                    modifier = Modifier.fillMaxWidth().clickable { onNavigateToStory(hero.id) },
                    colors = CardDefaults.cardColors(containerColor = BrandOrange.copy(alpha = 0.2f))
                ) {
                    Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                        AsyncImage(model = hero.mascotUrl, contentDescription = null, modifier = Modifier.size(50.dp).clip(RoundedCornerShape(25.dp)))
                        Spacer(modifier = Modifier.width(16.dp))
                        Column {
                            Text(if (language == "en") hero.nameEn else hero.nameKn, fontWeight = FontWeight.Bold, color = BrandBrown)
                            Text(if (language == "en") hero.titleEn else hero.titleKn, fontSize = 14.sp)
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapScreen(viewModel: AppViewModel, onNavigateToStory: (String) -> Unit) {
    val language by viewModel.language.collectAsState()
    val heroes = DataProvider.heroes

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (language == "en") "Heroic Regions" else "ವೀರ ಪ್ರದೇಶಗಳು", fontWeight = FontWeight.Bold, color = BrandBrown) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
            // Mocking a map with a list overlay or a visual representation
            // Since we don't have a real map SDK here, we'll display a scrollable list grouped by region.
            LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
                val groupedHeroes = heroes.groupBy { if (language == "en") it.regionEn else it.regionKn }
                groupedHeroes.forEach { (region, heroList) ->
                    item {
                        Text(region, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = BrandBrown, modifier = Modifier.padding(vertical = 8.dp))
                    }
                    items(heroList) { hero ->
                        Card(
                            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp).clickable { onNavigateToStory(hero.id) },
                            colors = CardDefaults.cardColors(containerColor = BrandOrange.copy(alpha = 0.2f))
                        ) {
                            Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                                AsyncImage(
                                    model = hero.mascotUrl,
                                    contentDescription = null,
                                    modifier = Modifier.size(50.dp).clip(RoundedCornerShape(25.dp)).background(BrandOrange)
                                )
                                Spacer(modifier = Modifier.width(16.dp))
                                Column {
                                    Text(if (language == "en") hero.nameEn else hero.nameKn, fontWeight = FontWeight.Bold, color = BrandBrown)
                                    Text(if (language == "en") hero.titleEn else hero.titleKn, fontSize = 14.sp)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StoriesExploreScreen(onNavigateToStory: (String) -> Unit) {
    val heroes = DataProvider.heroes
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("All Stories", fontWeight = FontWeight.Bold, color = BrandBrown) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
            )
        }
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(heroes) { hero ->
                Card(
                    modifier = Modifier.fillMaxWidth().clickable { onNavigateToStory(hero.id) },
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = BrandOrange.copy(alpha = 0.2f))
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(hero.nameEn, fontWeight = FontWeight.Bold, color = BrandBrown, fontSize = 18.sp)
                        Text(hero.titleEn, color = Color.DarkGray, fontSize = 14.sp)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizExploreScreen(onNavigateToQuiz: (String) -> Unit) {
    val heroes = DataProvider.heroes
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Quizzes", fontWeight = FontWeight.Bold, color = BrandBrown) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
            )
        }
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(heroes) { hero ->
                Card(
                    modifier = Modifier.fillMaxWidth().clickable { onNavigateToQuiz(hero.id) },
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = BrandGreen.copy(alpha = 0.2f))
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("${hero.nameEn} Quiz", fontWeight = FontWeight.Bold, color = BrandBrown, fontSize = 18.sp)
                        Text("${hero.quiz.size} Questions", color = Color.DarkGray, fontSize = 14.sp)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(viewModel: AppViewModel, onNavigateBack: () -> Unit = {}, onNavigateToAbout: () -> Unit = {}, onNavigateToHelpSupport: () -> Unit = {}) {
    val userName by viewModel.userName.collectAsState()
    val userProfileSeed by viewModel.userProfileSeed.collectAsState()
    val userProfileAvatarUri by viewModel.userProfileAvatarUri.collectAsState()
    val readStories by viewModel.readStories.collectAsState()
    val completedQuizzes by viewModel.completedQuizzes.collectAsState()
    val badges by viewModel.badges.collectAsState()
    val language by viewModel.language.collectAsState()
    
    var isEditing by remember { mutableStateOf(false) }
    var editName by remember { mutableStateOf(userName) }

    val context = androidx.compose.ui.platform.LocalContext.current
    val launcher = androidx.activity.compose.rememberLauncherForActivityResult(
        contract = androidx.activity.result.contract.ActivityResultContracts.GetContent()
    ) { uri: android.net.Uri? ->
        uri?.let {
            viewModel.updateUserProfileAvatarUri(it.toString())
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My Profile", fontWeight = FontWeight.Bold, color = BrandBrown, modifier = Modifier.fillMaxWidth(), textAlign = androidx.compose.ui.text.style.TextAlign.Center) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        androidx.compose.material3.Icon(Icons.Default.ChevronLeft, contentDescription = "Back", tint = BrandBrown)
                    }
                },
                actions = { Spacer(modifier = Modifier.width(48.dp)) }, // to balance the title
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues).padding(horizontal = 20.dp).verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            
            // User Header
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                val avatarUrl = userProfileAvatarUri ?: if (userProfileSeed == "default") "https://api.dicebear.com/7.x/adventurer-neutral/png?seed=user" else "https://api.dicebear.com/7.x/adventurer-neutral/png?seed=$userProfileSeed"
                
                Box(contentAlignment = Alignment.BottomEnd) {
                    AsyncImage(
                        model = avatarUrl,
                        contentDescription = "Profile Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(80.dp)
                            .clip(RoundedCornerShape(40.dp))
                            .background(BrandOrange)
                            .clickable { launcher.launch("image/*") }
                    )
                    androidx.compose.material3.Icon(
                        imageVector = Icons.Default.Verified, // Green check mimicking the badge
                        contentDescription = "Verified",
                        tint = BrandGreen,
                        modifier = Modifier
                            .size(24.dp)
                            .background(Color.White, RoundedCornerShape(12.dp))
                    )
                }
                
                Spacer(modifier = Modifier.width(16.dp))
                
                if (isEditing) {
                    Column(modifier = Modifier.weight(1f)) {
                        OutlinedTextField(
                            value = editName,
                            onValueChange = { editName = it },
                            label = { Text("Name") },
                            singleLine = true
                        )
                        Row {
                            TextButton(onClick = { 
                                viewModel.updateProfile(editName, userProfileSeed)
                                isEditing = false 
                            }) { Text("Save") }
                            TextButton(onClick = { isEditing = false }) { Text("Cancel") }
                        }
                    }
                } else {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(userName, fontSize = 22.sp, fontWeight = FontWeight.Bold, color = BrandBrown)
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            androidx.compose.material3.Icon(Icons.Default.Security, contentDescription=null, tint=BrandOrange, modifier=Modifier.size(14.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Heritage Explorer", fontSize = 14.sp, color = BrandBrown.copy(alpha=0.8f))
                        }
                    }
                    IconButton(onClick = { 
                        editName = userName
                        isEditing = true
                    }) {
                        androidx.compose.material3.Icon(Icons.Default.Edit, contentDescription = "Edit", tint = BrandBrown.copy(alpha=0.6f))
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Statistics Cards
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                shape = RoundedCornerShape(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Stories Read", fontSize = 12.sp, color = BrandBrown.copy(alpha=0.8f), fontWeight = FontWeight.Medium)
                        Text("${readStories.size}", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = BrandBrown)
                    }
                    Divider(color = BrandBrown.copy(alpha=0.1f), modifier = Modifier.height(30.dp).width(1.dp))
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Quizzes Taken", fontSize = 12.sp, color = BrandBrown.copy(alpha=0.8f), fontWeight = FontWeight.Medium)
                        Text("${completedQuizzes.size}", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = BrandBrown)
                    }
                    Divider(color = BrandBrown.copy(alpha=0.1f), modifier = Modifier.height(30.dp).width(1.dp))
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Badges Earned", fontSize = 12.sp, color = BrandBrown.copy(alpha=0.8f), fontWeight = FontWeight.Medium)
                        Text("${badges.size}", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = BrandBrown)
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Menu Items
            val profileItems = listOf(
                Triple("Language", Icons.Default.Language, if (language == "en") "English" else "ಕನ್ನಡ"),
                Triple("About Namma Kathey", Icons.Default.Info, null),
                Triple("Help & Support", Icons.Default.HeadsetMic, null)
            )
            
            profileItems.forEachIndexed { index, (title, icon, trailing) ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { 
                            if (title == "Language") viewModel.toggleLanguage() 
                            else if (title == "About Namma Kathey") onNavigateToAbout()
                            else if (title == "Help & Support") onNavigateToHelpSupport()
                        }
                        .padding(vertical = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    androidx.compose.material3.Icon(icon, contentDescription = null, tint = BrandBrown, modifier = Modifier.size(20.dp))
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(title, color = BrandBrown, fontSize = 16.sp, fontWeight = FontWeight.Medium, modifier = Modifier.weight(1f))
                    if (trailing != null) {
                        Text(trailing as String, color = BrandBrown, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                    androidx.compose.material3.Icon(Icons.Default.ChevronRight, contentDescription = null, tint = BrandBrown.copy(alpha=0.5f), modifier = Modifier.size(16.dp))
                }
                if (index < profileItems.size - 1) {
                    Divider(color = BrandBrown.copy(alpha=0.05f))
                }
            }
            
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(viewModel: AppViewModel, onNavigateToStory: (String) -> Unit) {
    var searchQuery by remember { mutableStateOf("") }
    val heroes = DataProvider.heroes
    val filteredHeroes = heroes.filter { 
        it.nameEn.contains(searchQuery, ignoreCase = true) || 
        it.titleEn.contains(searchQuery, ignoreCase = true) 
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Search", fontWeight = FontWeight.Bold, color = BrandBrown) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues).padding(16.dp)
        ) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Search stories...") },
                shape = RoundedCornerShape(12.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                items(filteredHeroes) { hero ->
                    Card(
                        modifier = Modifier.fillMaxWidth().clickable { onNavigateToStory(hero.id) },
                        colors = CardDefaults.cardColors(containerColor = Color.White)
                    ) {
                        Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
                            AsyncImage(
                                model = hero.mascotUrl,
                                contentDescription = null,
                                modifier = Modifier.size(50.dp).clip(RoundedCornerShape(8.dp))
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Column {
                                Text(hero.nameEn, fontWeight = FontWeight.Bold, color = BrandBrown)
                                Text(hero.titleEn, fontSize = 12.sp, color = Color.Gray)
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BadgesScreen(viewModel: AppViewModel) {
    val badges by viewModel.badges.collectAsState()
    val heroes = DataProvider.heroes

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My Badges", fontWeight = FontWeight.Bold, color = BrandBrown) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
            )
        }
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            if (badges.isEmpty()) {
                item {
                    Text("No badges earned yet. Complete quizzes to earn badges!", color = Color.Gray)
                }
            } else {
                items(badges) { badgeId ->
                    val hero = heroes.find { it.id == badgeId }
                    if (hero != null) {
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            colors = CardDefaults.cardColors(containerColor = BrandOrange.copy(alpha = 0.2f))
                        ) {
                            Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                                AsyncImage(
                                    model = hero.mascotUrl,
                                    contentDescription = null,
                                    modifier = Modifier.size(60.dp).clip(RoundedCornerShape(30.dp)).background(BrandOrange)
                                )
                                Spacer(modifier = Modifier.width(16.dp))
                                Column {
                                    Text("${hero.nameEn} Badge", fontWeight = FontWeight.Bold, color = BrandBrown, fontSize = 18.sp)
                                    Text("Awarded for completing the quiz", fontSize = 14.sp)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(viewModel: AppViewModel, onLoginSuccess: () -> Unit) {
    var isRegistering by remember { mutableStateOf(false) }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (isRegistering) "Register" else "Login", fontWeight = FontWeight.Bold, color = BrandBrown) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues).padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Namma Kathey", fontSize = 32.sp, fontWeight = FontWeight.Bold, color = BrandOrange)
            Spacer(modifier = Modifier.height(32.dp))
            
            if (errorMessage != null) {
                Text(errorMessage!!, color = MaterialTheme.colorScheme.error, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(16.dp))
            }
            
            if (isRegistering) {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Name") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
            
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = androidx.compose.ui.text.input.PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(32.dp))
            
            Button(
                onClick = {
                    errorMessage = null
                    if (isRegistering) {
                        if (viewModel.register(email, password)) {
                            if (name.isNotEmpty()) {
                                viewModel.updateProfile(name, "default")
                            }
                            viewModel.login(email, password)
                            onLoginSuccess()
                        } else {
                            errorMessage = "Registration failed. Email might already exist or inputs are valid."
                        }
                    } else {
                        if (viewModel.login(email, password)) {
                            onLoginSuccess()
                        } else {
                            errorMessage = "Invalid email or password."
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = BrandBrown)
            ) {
                Text(if (isRegistering) "Register" else "Login", color = Color.White)
            }
            Spacer(modifier = Modifier.height(16.dp))
            TextButton(onClick = { 
                isRegistering = !isRegistering 
                errorMessage = null
            }) {
                Text(if (isRegistering) "Already have an account? Login" else "Don't have an account? Register", color = BrandBrown)
            }
        }
    }
}

