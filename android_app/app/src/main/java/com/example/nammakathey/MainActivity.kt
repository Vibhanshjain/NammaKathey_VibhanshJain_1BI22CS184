package com.example.nammakathey

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nammakathey.ui.screens.*
import com.example.nammakathey.viewmodel.AppViewModel

import com.example.nammakathey.ui.theme.NammaKatheyTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.collectAsState
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.nammakathey.ui.theme.BrandBrown
import com.example.nammakathey.ui.theme.BrandOrange

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Alignment
import coil.compose.AsyncImage
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.WorkspacePremium
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Login
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.draw.clip

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val appViewModel: AppViewModel = viewModel()
            val isDarkMode by appViewModel.isDarkMode.collectAsState()
            val isLoggedIn by appViewModel.isLoggedIn.collectAsState()
            
            NammaKatheyTheme(darkTheme = isDarkMode) {
                // Navigation setup
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                
                val drawerState = androidx.compose.material3.rememberDrawerState(initialValue = androidx.compose.material3.DrawerValue.Closed)
                val scope = androidx.compose.runtime.rememberCoroutineScope()

                androidx.compose.material3.ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        androidx.compose.material3.ModalDrawerSheet(
                            modifier = Modifier.background(MaterialTheme.colorScheme.background)
                        ) {
                            val userProfileSeed by appViewModel.userProfileSeed.collectAsState()
                            val userProfileAvatarUri by appViewModel.userProfileAvatarUri.collectAsState()
                            val userName by appViewModel.userName.collectAsState()
                            val avatarUrl = userProfileAvatarUri ?: if (userProfileSeed == "default") "https://api.dicebear.com/7.x/adventurer-neutral/png?seed=user" else "https://api.dicebear.com/7.x/adventurer-neutral/png?seed=$userProfileSeed"

                            Box(modifier = Modifier.fillMaxWidth().height(160.dp).background(BrandOrange.copy(alpha=0.3f))) {
                                AsyncImage(
                                    model = "https://images.unsplash.com/photo-1600088193077-8fa538965f90?q=80&w=600&auto=format&fit=crop", // Temp landscape
                                    contentDescription = "Header",
                                    contentScale = androidx.compose.ui.layout.ContentScale.Crop,
                                    modifier = Modifier.fillMaxSize()
                                )
                                Box(modifier = Modifier.fillMaxSize().padding(16.dp), contentAlignment = Alignment.CenterStart) {
                                    AsyncImage(
                                        model = avatarUrl,
                                        contentDescription = "Profile",
                                        modifier = Modifier.size(72.dp).clip(androidx.compose.foundation.shape.CircleShape).background(BrandOrange),
                                        contentScale = androidx.compose.ui.layout.ContentScale.Crop
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            
                            val menuItems = listOf(
                                Triple("Home", androidx.compose.material.icons.Icons.Default.Home, "home"),
                                Triple("Stories", androidx.compose.material.icons.Icons.Default.MenuBook, "stories_explore"),
                                Triple("Quiz", androidx.compose.material.icons.Icons.Default.Quiz, "quiz_explore"),
                                Triple("Badges", androidx.compose.material.icons.Icons.Default.WorkspacePremium, "badges_explore"),
                                Triple("Map", androidx.compose.material.icons.Icons.Default.Map, "map_explore"),
                                Triple("My Profile", androidx.compose.material.icons.Icons.Default.Person, "profile"),
                                Triple("About Us", androidx.compose.material.icons.Icons.Default.Info, "about")
                            )
                            
                            menuItems.forEach { (title, icon, route) ->
                                androidx.compose.material3.NavigationDrawerItem(
                                    label = { Text(title, color = BrandBrown) },
                                    icon = { androidx.compose.material3.Icon(icon, contentDescription = null, tint = BrandBrown) },
                                    selected = false,
                                    onClick = { 
                                        scope.launch { drawerState.close() } 
                                        navController.navigate(route)
                                    },
                                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 2.dp),
                                    colors = androidx.compose.material3.NavigationDrawerItemDefaults.colors(unselectedContainerColor = androidx.compose.ui.graphics.Color.Transparent)
                                )
                            }
                            
                            Spacer(modifier = Modifier.weight(1f))
                            androidx.compose.material3.NavigationDrawerItem(
                                label = { Text(if (isDarkMode) "Light Mode" else "Dark Mode", color = BrandBrown) },
                                icon = { androidx.compose.material3.Icon(if(isDarkMode) androidx.compose.material.icons.Icons.Default.LightMode else androidx.compose.material.icons.Icons.Default.DarkMode, contentDescription=null, tint=BrandBrown) },
                                selected = false,
                                onClick = { appViewModel.toggleDarkMode() },
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 2.dp),
                                colors = androidx.compose.material3.NavigationDrawerItemDefaults.colors(unselectedContainerColor = androidx.compose.ui.graphics.Color.Transparent)
                            )
                            if (isLoggedIn) {
                                androidx.compose.material3.NavigationDrawerItem(
                                    label = { Text("Logout", color = androidx.compose.ui.graphics.Color.Red) },
                                    icon = { androidx.compose.material3.Icon(androidx.compose.material.icons.Icons.Default.Logout, contentDescription=null, tint=androidx.compose.ui.graphics.Color.Red) },
                                    selected = false,
                                    onClick = { 
                                        appViewModel.logout()
                                        scope.launch { drawerState.close() }
                                        navController.navigate("login") { popUpTo(0) }
                                    },
                                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                                    colors = androidx.compose.material3.NavigationDrawerItemDefaults.colors(unselectedContainerColor = androidx.compose.ui.graphics.Color.Transparent)
                                )
                            } else {
                                androidx.compose.material3.NavigationDrawerItem(
                                    label = { Text("Login", color = BrandBrown) },
                                    icon = { androidx.compose.material3.Icon(androidx.compose.material.icons.Icons.Default.Login, contentDescription=null, tint=BrandBrown) },
                                    selected = false,
                                    onClick = { 
                                        scope.launch { drawerState.close() }
                                        navController.navigate("login")
                                    },
                                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                                    colors = androidx.compose.material3.NavigationDrawerItemDefaults.colors(unselectedContainerColor = androidx.compose.ui.graphics.Color.Transparent)
                                )
                            }
                        }
                    }
                ) {
                    Scaffold(
                    bottomBar = {
                        val routesWithBottomBar = listOf("home", "search", "saved", "profile")
                        if (currentRoute in routesWithBottomBar) {
                            NavigationBar(
                                containerColor = MaterialTheme.colorScheme.background,
                                contentColor = BrandBrown
                            ) {
                                NavigationBarItem(
                                    icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
                                    label = { Text("Home") },
                                    selected = currentRoute == "home",
                                    onClick = {
                                        navController.navigate("home") {
                                            popUpTo("home") { inclusive = true }
                                        }
                                    },
                                    colors = NavigationBarItemDefaults.colors(
                                        selectedIconColor = BrandOrange,
                                        unselectedIconColor = BrandBrown,
                                        selectedTextColor = BrandOrange,
                                        unselectedTextColor = BrandBrown,
                                        indicatorColor = MaterialTheme.colorScheme.background
                                    )
                                )
                                NavigationBarItem(
                                    icon = { Icon(Icons.Outlined.Search, contentDescription = "Search") },
                                    label = { Text("Search") },
                                    selected = currentRoute == "search",
                                    onClick = {
                                        navController.navigate("search") {
                                            popUpTo("home") { inclusive = false }
                                        }
                                    },
                                    colors = NavigationBarItemDefaults.colors(
                                        selectedIconColor = BrandOrange,
                                        unselectedIconColor = BrandBrown,
                                        selectedTextColor = BrandOrange,
                                        unselectedTextColor = BrandBrown,
                                        indicatorColor = MaterialTheme.colorScheme.background
                                    )
                                )
                                NavigationBarItem(
                                    icon = { Icon(Icons.Outlined.BookmarkBorder, contentDescription = "Saved") },
                                    label = { Text("Saved") },
                                    selected = currentRoute == "saved",
                                    onClick = {
                                        navController.navigate("saved") {
                                            popUpTo("home") { inclusive = false }
                                        }
                                    },
                                    colors = NavigationBarItemDefaults.colors(
                                        selectedIconColor = BrandOrange,
                                        unselectedIconColor = BrandBrown,
                                        selectedTextColor = BrandOrange,
                                        unselectedTextColor = BrandBrown,
                                        indicatorColor = MaterialTheme.colorScheme.background
                                    )
                                )
                                NavigationBarItem(
                                    icon = { Icon(Icons.Outlined.Person, contentDescription = "Profile") },
                                    label = { Text("Profile") },
                                    selected = currentRoute == "profile",
                                    onClick = {
                                        navController.navigate("profile") {
                                            popUpTo("home") { inclusive = false }
                                        }
                                    },
                                    colors = NavigationBarItemDefaults.colors(
                                        selectedIconColor = BrandOrange,
                                        unselectedIconColor = BrandBrown,
                                        selectedTextColor = BrandOrange,
                                        unselectedTextColor = BrandBrown,
                                        indicatorColor = MaterialTheme.colorScheme.background
                                    )
                                )
                            }
                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController, 
                        startDestination = if (isLoggedIn) "home" else "login",
                        modifier = Modifier.padding(innerPadding).fillMaxSize()
                    ) {
                        composable("login") {
                            LoginScreen(
                                viewModel = appViewModel,
                                onLoginSuccess = {
                                    navController.navigate("home") { popUpTo(0) }
                                }
                            )
                        }
                        composable("home") {
                            HomeScreen(
                                viewModel = appViewModel,
                                onOpenMenu = { scope.launch { drawerState.open() } },
                                onNavigateToStory = { heroId ->
                                    navController.navigate("story/$heroId")
                                },
                                onNavigateToStories = { navController.navigate("stories_explore") },
                                onNavigateToQuiz = { navController.navigate("quiz_explore") },
                                onNavigateToBadges = { navController.navigate("badges_explore") },
                                onNavigateToMap = { navController.navigate("map_explore") },
                                onNavigateToNotifications = { navController.navigate("notifications") }
                            )
                        }
                        composable("search") { SearchScreen(appViewModel, onNavigateToStory = { heroId -> navController.navigate("story/$heroId") }) }
                        composable("saved") { SavedScreen(appViewModel, onNavigateToStory = { heroId -> navController.navigate("story/$heroId") }) }
                        composable("profile") { 
                            ProfileScreen(
                                viewModel = appViewModel,
                                onNavigateBack = { navController.popBackStack() },
                                onNavigateToAbout = { navController.navigate("about") },
                                onNavigateToHelpSupport = { navController.navigate("help") }
                            ) 
                        }
                        composable("about") { AboutUsScreen(onNavigateBack = { navController.popBackStack() }) }
                        composable("help") { HelpSupportScreen(onNavigateBack = { navController.popBackStack() }) }
                        composable("feedback") { FeedbackScreen() }
                        composable("notifications") { NotificationsScreen() }
                        composable("stories_explore") {
                            StoriesExploreScreen(onNavigateToStory = { heroId ->
                                navController.navigate("story/$heroId")
                            })
                        }
                        composable("quiz_explore") {
                            QuizExploreScreen(onNavigateToQuiz = { heroId ->
                                navController.navigate("quiz/$heroId")
                            })
                        }
                        composable("badges_explore") { BadgesScreen(appViewModel) }
                        composable("map_explore") { MapScreen(appViewModel, onNavigateToStory = { heroId -> navController.navigate("story/$heroId") }) }
                        composable("story/{heroId}") { backStackEntry ->
                            val heroId = backStackEntry.arguments?.getString("heroId") ?: ""
                            StoryReaderScreen(
                                heroId = heroId,
                                viewModel = appViewModel,
                                onNavigateBack = { navController.popBackStack() },
                                onNavigateToQuiz = { id -> navController.navigate("quiz/$id") }
                            )
                        }
                        composable("quiz/{heroId}") { backStackEntry ->
                            val heroId = backStackEntry.arguments?.getString("heroId") ?: ""
                            QuizScreen(
                                heroId = heroId,
                                viewModel = appViewModel,
                                onNavigateBack = { navController.popBackStack() },
                                onNavigateHome = {
                                    navController.popBackStack("home", inclusive = false)
                                }
                            )
                        }
                    }
                }
                }
            }
        }
    }
}
