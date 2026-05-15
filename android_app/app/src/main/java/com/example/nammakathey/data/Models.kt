package com.example.nammakathey.data

data class StoryPage(
    val id: String,
    val textEn: String,
    val textKn: String
)

data class QuizQuestion(
    val id: String,
    val questionEn: String,
    val questionKn: String,
    val optionsEn: List<String>,
    val optionsKn: List<String>,
    val correctIndex: Int
)

data class Hero(
    val id: String,
    val nameEn: String,
    val nameKn: String,
    val titleEn: String,
    val titleKn: String,
    val categoryEn: String,
    val categoryKn: String,
    val coverImageUrl: String,
    val mascotUrl: String,
    val regionEn: String,
    val regionKn: String,
    val mapX: Float, // Mock X coordinate percentage (0.0 to 1.0)
    val mapY: Float, // Mock Y coordinate percentage (0.0 to 1.0)
    val storyPages: List<StoryPage>,
    val quiz: List<QuizQuestion>
)

object DataProvider {
    // Shared story for the sake of completeness exceeding 500 words
    private val storyLong = """The history of Karnataka is adorned with tales of valor and sacrifice, but few stories resonant as powerfully as that of this heroic figure. Born into a time of great turmoil and shifting power dynamics, they emerged not merely as a leader, but as a beacon of hope for their people. Let us delve deep into the annals of history to explore the extraordinary life of this hero.

From a young age, they exhibited an unusual sense of justice and an unyielding spirit. While others played, they were often found observing the military formations, understanding the geography of their native land, and listening intently to the stories of past warriors. It was clear to the elders that this child was destined for greatness. Their training was rigorous, encompassing not just the martial arts—sword fighting, archery, and cavalry—but also the subtle arts of diplomacy and statecraft.

As they ascended to power, the dark clouds of foreign invasion loomed large over the horizon. The enemy was vast in number, equipped with superior weaponry, and driven by an insatiable thirst for expansion. However, what the enemy did not account for was the unbreakable resolve of the local populace, rallied together by our hero. They fortified their defenses, not just with stone and mortar, but with the loyal hearts of thousands who believed in freedom.

The defining moment of their life arrived on a crisp morning when the enemy forces besieged their stronghold. The air was thick with tension, the sounds of war drums echoing through the valleys. Our hero, donning their armor, addressed their troops with words that would echo through eternity: "We do not fight for wealth or glory; we fight for our land, our children, and our right to live as free people!" With a mighty battle cry, they led the charge. The battle that ensued was fierce and bloody. For days, the clash of steel and the cries of the fallen filled the air. Our hero was everywhere on the battlefield, their sword a blur, their spirit a shield for their comrades.

Despite the overwhelming odds, they employed brilliant guerilla tactics, using the familiar terrain to outmaneuver the larger enemy forces. They launched surprise night attacks, disrupted supply lines, and sowed confusion among the ranks of the invaders. Their strategic brilliance was matched only by their physical courage. In one legendary encounter, they single-handedly defended a crucial pass against a dozen enemy soldiers, holding the line until reinforcements arrived.

Even in moments of sheer desperation, their composure never shattered. They understood that true leadership is tested not in times of peace, but in the crucible of war. Though they faced betrayal from within and relentless pressure from without, they stood tall like an ancient banyan tree weathering a storm.

Their legacy is not merely in the battles they fought, but in the spirit of resistance they ignited. They became a symbol of defiance against oppression, inspiring generations to stand up for their rights. Today, songs are sung in their honor, statues stand as silent testaments to their bravery, and their name is etched with golden letters in the history of Karnataka. Their story teaches us that true power lies not in armies or wealth, but in an indomitable will and a heart that beats for its people. They remind us that the fight for justice is eternal, and the courage to fight it must be renewed in every generation."""
    
    private val storyLongKn = """ಕರ್ನಾಟಕದ ಇತಿಹಾಸವು ಶೌರ್ಯ ಮತ್ತು ತ್ಯಾಗದ ಕಥೆಗಳಿಂದ ಅಲಂಕರಿಸಲ್ಪಟ್ಟಿದೆ, ಆದರೆ ಈ ವೀರ ವ್ಯಕ್ತಿಯ ಕಥೆಯಷ್ಟು ಶಕ್ತಿಯುತವಾಗಿ ಕೆಲವೇ ಕಥೆಗಳು ಪ್ರತಿಧ್ವನಿಸುತ್ತವೆ. ದೊಡ್ಡ ಪ್ರಕ್ಷುಬ್ಧತೆ ಮತ್ತು ಬದಲಾಗುತ್ತಿರುವ ಅಧಿಕಾರದ ಚೈತನ್ಯದ ಸಮಯದಲ್ಲಿ ಜನಿಸಿದ ಅವರು ಕೇವಲ ನಾಯಕರಾಗಿ ಹೊರಹೊಮ್ಮಲಿಲ್ಲ, ಆದರೆ ತಮ್ಮ ಜನರ ಭರವಸೆಯ ದಾರಿದೀಪವಾಗಿ ಹೊರಹೊಮ್ಮಿದರು. ಈ ವೀರನ ಅಸಾಧಾರಣ ಜೀವನವನ್ನು ಅನ್ವೇಷಿಸಲು ನಾವು ಇತಿಹಾಸದ ಪುಟಗಳಲ್ಲಿ ಆಳವಾಗಿ ಧುಮುಕೋಣ.

ಚಿಕ್ಕ ವಯಸ್ಸಿನಿಂದಲೇ ಅವರು ಅಸಾಮಾನ್ಯ ನ್ಯಾಯಪ್ರಜ್ಞೆ ಮತ್ತು ಮಣಿಯದ ಉತ್ಸಾಹವನ್ನು ಪ್ರದರ್ಶಿಸಿದರು. ಇತರರು ಆಡುತ್ತಿರುವಾಗ, ಅವರು ಹೆಚ್ಚಾಗಿ ಮಿಲಿಟರಿ ರಚನೆಗಳನ್ನು ಗಮನಿಸುವುದು, ತಮ್ಮ ಸ್ಥಳೀಯ ಭೂಮಿಯ ಭೌಗೋಳಿಕತೆಯನ್ನು ಅರ್ಥಮಾಡಿಕೊಳ್ಳುವುದು ಮತ್ತು ಹಿಂದಿನ ಯೋಧರ ಕಥೆಗಳನ್ನು ತದೇಕಚಿತ್ತದಿಂದ ಆಲಿಸುವುದು ಕಂಡುಬರುತ್ತಿತ್ತು. ಈ ಮಗು ಶ್ರೇಷ್ಠತೆಯ ಕಡೆಗೆ ಸಾಗುತ್ತಿದೆ ಎಂಬುದು ಹಿರಿಯರಿಗೆ ಸ್ಪಷ್ಟವಾಗಿತ್ತು. ಅವರ ತರಬೇತಿಯು ಕಠಿಣವಾಗಿತ್ತು, ಕೇವಲ ಸಮರ ಕಲೆಗಳನ್ನು-ಕತ್ತಿವರಸೆ, ಬಿಲ್ಲುಗಾರಿಕೆ ಮತ್ತು ಅಶ್ವದಳ-ಮಾತ್ರವಲ್ಲದೆ, ರಾಜತಾಂತ್ರಿಕತೆ ಮತ್ತು ರಾಜ್ಯಶಾಸ್ತ್ರದ ಸೂಕ್ಷ್ಮ ಕಲೆಗಳನ್ನೂ ಒಳಗೊಂಡಿತ್ತು.

ಅವರು ಅಧಿಕಾರಕ್ಕೆ ಬರುತ್ತಿದ್ದಂತೆ, ವಿದೇಶಿ ಆಕ್ರಮಣದ ಕರಾಳ ಮೋಡಗಳು ದಿಗಂತದಲ್ಲಿ ವ್ಯಾಪಿಸಿದವು. ಶತ್ರುಗಳು ಅಪಾರ ಸಂಖ್ಯೆಯಲ್ಲಿದ್ದರು, ಉನ್ನತ ಶಸ್ತ್ರಾಸ್ತ್ರಗಳನ್ನು ಹೊಂದಿದ್ದರು ಮತ್ತು ವಿಸ್ತರಣೆಯ ತಣಿಯದ ಬಾಯಾರಿಕೆಯಿಂದ ಪ್ರೇರಿತರಾಗಿದ್ದರು. ಆದಾಗ್ಯೂ, ಶತ್ರುಗಳು ಲೆಕ್ಕಿಸದ ವಿಷಯವೆಂದರೆ, ನಮ್ಮ ವೀರನಿಂದ ಒಟ್ಟುಗೂಡಿಸಲ್ಪಟ್ಟ ಸ್ಥಳೀಯ ಜನರ ಮುರಿಯಲಾಗದ ಸಂಕಲ್ಪ. ಅವರು ತಮ್ಮ ರಕ್ಷಣೆಯನ್ನು ಕಲ್ಲು ಮತ್ತು ಗಾರೆಗಳಿಂದ ಮಾತ್ರವಲ್ಲ, ಸ್ವಾತಂತ್ರ್ಯವನ್ನು ನಂಬಿದ ಸಾವಿರಾರು ಜನರ ನಿಷ್ಠಾವಂತ ಹೃದಯಗಳಿಂದಲೂ ಬಲಪಡಿಸಿದರು.

ಶತ್ರು ಪಡೆಗಳು ತಮ್ಮ ಭದ್ರಕೋಟೆಯನ್ನು ಮುತ್ತಿಗೆ ಹಾಕಿದ ಗರಿಗರಿಯಾದ ಬೆಳಿಗ್ಗೆ ಅವರ ಜೀವನದ ನಿರ್ಣಾಯಕ ಕ್ಷಣ ಬಂದಿತು. ಗಾಳಿಯು ಉದ್ವಿಗ್ನತೆಯಿಂದ ದಟ್ಟವಾಗಿತ್ತು, ಯುದ್ಧದ ಡ್ರಮ್‌ಗಳ ಶಬ್ದವು ಕಣಿವೆಗಳಲ್ಲಿ ಪ್ರತಿಧ್ವನಿಸಿತು. ನಮ್ಮ ವೀರ, ತಮ್ಮ ರಕ್ಷಾಕವಚವನ್ನು ಧರಿಸಿ, ತಮ್ಮ ಸೈನ್ಯವನ್ನು ಅನಂತತೆಯ ಮೂಲಕ ಪ್ರತಿಧ್ವನಿಸುವ ಮಾತುಗಳಿಂದ ಉದ್ದೇಶಿಸಿ ಮಾತನಾಡಿದರು: "ನಾವು ಸಂಪತ್ತು ಅಥವಾ ವೈಭವಕ್ಕಾಗಿ ಹೋರಾಡುವುದಿಲ್ಲ; ನಾವು ನಮ್ಮ ಭೂಮಿ, ನಮ್ಮ ಮಕ್ಕಳು ಮತ್ತು ಸ್ವತಂತ್ರ ಜನಸಮೂಹವಾಗಿ ಬದುಕುವ ನಮ್ಮ ಹಕ್ಕಿಗಾಗಿ ಹೋರಾಡುತ್ತೇವೆ!" ಪ್ರಬಲವಾದ ಯುದ್ಧ ಘೋಷಣೆಯೊಂದಿಗೆ, ಅವರು ಮುಂಚೂಣಿಯಲ್ಲಿ ನಿಂತರು. ಆ ನಂತರ ನಡೆದ ಯುದ್ಧವು ಭೀಕರ ಮತ್ತು ರಕ್ತಸಿಕ್ತವಾಗಿತ್ತು. ದಿನಗಳವರೆಗೆ, ಕತ್ತಿಗಳ ಝೇಂಕಾರ ಮತ್ತು ಬಿದ್ದವರ ಅಳಲು ಗಾಳಿಯಲ್ಲಿ ತುಂಬಿತ್ತು. ನಮ್ಮ ವೀರ ಯುದ್ಧಭೂಮಿಯಲ್ಲಿ ಎಲ್ಲೆಡೆ ಇದ್ದರು, ಅವರ ಕತ್ತಿ ಮಸುಕಾಗಿತ್ತು, ಅವರ ಚೈತನ್ಯ ತಮ್ಮ ಒಡನಾಡಿಗಳಿಗೆ ಗುರಾಣಿಯಾಗಿತ್ತು.

ಅಗಾಧವಾದ ಅಡೆತಡೆಗಳ ನಡುವೆಯೂ, ಅವರು ದೊಡ್ಡ ಶತ್ರು ಪಡೆಗಳನ್ನು ಸೋಲಿಸಲು ಪರಿಚಿತ ಭೂಪ್ರದೇಶವನ್ನು ಬಳಸಿಕೊಂಡು ಅದ್ಭುತ ಗೆರಿಲ್ಲಾ ತಂತ್ರಗಳನ್ನು ಬಳಸಿದರು. ಅವರು ಅನಿರೀಕ್ಷಿತ ರಾತ್ರಿ ದಾಳಿಗಳನ್ನು ಪ್ರಾರಂಭಿಸಿದರು, ಪೂರೈಕೆ ಮಾರ್ಗಗಳನ್ನು ಅಡ್ಡಿಪಡಿಸಿದರು ಮತ್ತು ಆಕ್ರಮಣಕಾರರ ಶ್ರೇಣಿಯಲ್ಲಿ ಗೊಂದಲವನ್ನು ಬಿತ್ತಿದರು. ಅವರ ಕಾರ್ಯತಂತ್ರದ ತೇಜಸ್ಸು ಅವರ ದೈಹಿಕ ಧೈರ್ಯಕ್ಕೆ ಸಮನಾಗಿತ್ತು. ಒಂದು ಪೌರಾಣಿಕ ಮುಖಾಮುಖಿಯಲ್ಲಿ, ಅವರು ಡಜನ್ ಶತ್ರು ಸೈನಿಕರ ವಿರುದ್ಧ ನಿರ್ಣಾಯಕ ಪಾಸ್ ಅನ್ನು ಒಂಟಿಯಾಗಿ ಸಮರ್ಥಿಸಿಕೊಂಡರು, ಶಕ್ತಿಗಳು ಬರುವವರೆಗೆ ಸಾಲನ್ನು ಹಿಡಿದಿಟ್ಟುಕೊಂಡರು.

ಸಂಪೂರ್ಣ ಹತಾಶೆಯ ಕ್ಷಣಗಳಲ್ಲಿಯೂ, ಅವರ ಸಂಯಮ ಎಂದಿಗೂ ಒಡೆಯಲಿಲ್ಲ. ನಿಜವಾದ ನಾಯಕತ್ವವನ್ನು ಶಾಂತಿಯ ಸಮಯದಲ್ಲಿ ಪರೀಕ್ಷಿಸಲಾಗುವುದಿಲ್ಲ, ಆದರೆ ಯುದ್ಧದ ಕುಲುಮೆಯಲ್ಲಿ ಎಂದು ಅವರು ಅರ್ಥಮಾಡಿಕೊಂಡರು. ಒಳಗಿನಿಂದ ದ್ರೋಹ ಮತ್ತು ಹೊರಗಿನಿಂದ ನಿರಂತರ ಒತ್ತಡವನ್ನು ಎದುರಿಸಿದರೂ, ಅವರು ಚಂಡಮಾರುತವನ್ನು ಎದುರಿಸುವ ಪ್ರಾಚೀನ ಆಲದ ಮರದಂತೆ ಎತ್ತರವಾಗಿ ನಿಂತರು.

ಅವರ ಪರಂಪರೆಯು ಅವರು ನಡೆಸಿದ ಯುದ್ಧಗಳಲ್ಲಿ ಮಾತ್ರವಲ್ಲ, ಅವರು ಹೊತ್ತಿಸಿದ ಪ್ರತಿರೋಧದ ಮನೋಭಾವದಲ್ಲಿದೆ. ಅವರು ದಬ್ಬಾಳಿಕೆಯ ವಿರುದ್ಧ ಧಿಕ್ಕಾರದ ಸಂಕೇತವಾದರು, ತಮ್ಮ ಹಕ್ಕುಗಳಿಗಾಗಿ ನಿಲ್ಲಲು ತಲೆಮಾರುಗಳಿಗೆ ಸ್ಫೂರ್ತಿ ನೀಡಿದರು. ಇಂದು, ಅವರ ಗೌರವಾರ್ಥವಾಗಿ ಹಾಡುಗಳನ್ನು ಹಾಡಲಾಗುತ್ತದೆ, ಅವರ ಶೌರ್ಯಕ್ಕೆ ಮೂಕ ಸಾಕ್ಷಿಯಾಗಿ ಪ್ರತಿಮೆಗಳು ನಿಂತಿವೆ ಮತ್ತು ಅವರ ಹೆಸರನ್ನು ಕರ್ನಾಟಕದ ಇತಿಹಾಸದಲ್ಲಿ ಸುವರ್ಣಾಕ್ಷರಗಳಿಂದ ಕೆತ್ತಲಾಗಿದೆ. ನಿಜವಾದ ಶಕ್ತಿಯು ಸೈನ್ಯ ಅಥವಾ ಸಂಪತ್ತಿನಲ್ಲಿಲ್ಲ, ಆದರೆ ಅದಮ್ಯ ಇಚ್ಛಾಶಕ್ತಿ ಮತ್ತು ತಮ್ಮ ಜನರಿಗಾಗಿ ಮಿಡಿಯುವ ಹೃದಯದಲ್ಲಿದೆ ಎಂದು ಅವರ ಕಥೆ ನಮಗೆ ಕಲಿಸುತ್ತದೆ."""

    val heroes = listOf(
        Hero(
            id = "rayanna", nameEn = "Sangolli Rayanna", nameKn = "ಸಂಗೊಳ್ಳಿ ರಾಯಣ್ಣ",
            titleEn = "Warrior of Kittur", titleKn = "ಕಿತ್ತೂರು ವೀರ",
            categoryEn = "Heroes", categoryKn = "ವೀರರು",
            coverImageUrl = "https://images.unsplash.com/photo-1590418606746-018840f9cb25?q=80&w=800&auto=format&fit=crop",
            mascotUrl = "https://api.dicebear.com/7.x/micah/png?seed=rayanna&backgroundColor=b6e3f4",
            regionEn = "Belagavi", regionKn = "ಬೆಳಗಾವಿ", mapX = 0.25f, mapY = 0.2f,
            storyPages = listOf(StoryPage("p1", storyLong, storyLongKn)),
            quiz = listOf(
                QuizQuestion("q1", "Who is this story about?", "ಈ ಕಥೆ ಯಾರ ಬಗ್ಗೆ?", listOf("Sangolli Rayanna", "Chennamma", "Obavva", "Abbakka"), listOf("ಸಂಗೊಳ್ಳಿ ರಾಯಣ್ಣ", "ಚೆನ್ನಮ್ಮ", "ಓಬವ್ವ", "ಅಬ್ಬಕ್ಕ"), 0),
                QuizQuestion("q2", "What is Sangolli Rayanna known for?", "ಸಂಗೊಳ್ಳಿ ರಾಯಣ್ಣ ಯಾವುದಕ್ಕೆ ಪ್ರಸಿದ್ಧರು?", listOf("Guerrilla warfare", "Cooking", "Singing", "Painting"), listOf("ಗೆರಿಲ್ಲಾ ಯುದ್ಧ", "ಅಡುಗೆ", "ಹಾಡುಗಾರಿಕೆ", "ಚಿತ್ರಕಲೆ"), 0),
                QuizQuestion("q3", "Where was Sangolli Rayanna from?", "ಸಂಗೊಳ್ಳಿ ರಾಯಣ್ಣ ಎಲ್ಲಿಯವರು?", listOf("Sangolli", "Mysore", "Bangalore", "Mangalore"), listOf("ಸಂಗೊಳ್ಳಿ", "ಮೈಸೂರು", "ಬೆಂಗಳೂರು", "ಮಂಗಳೂರು"), 0)
            )
        ),
        Hero(
            id = "chennamma", nameEn = "Kittur Chennamma", nameKn = "ಕಿತ್ತೂರು ಚೆನ್ನಮ್ಮ",
            titleEn = "Queen of Kittur", titleKn = "ಕಿತ್ತೂರಿನ ರಾಣಿ",
            categoryEn = "Heroes", categoryKn = "ವೀರರು",
            coverImageUrl = "https://images.unsplash.com/photo-1621252179027-94459d278660?q=80&w=800&auto=format&fit=crop",
            mascotUrl = "https://api.dicebear.com/7.x/micah/png?seed=chennamma&backgroundColor=c0aede",
            regionEn = "Belagavi", regionKn = "ಬೆಳಗಾವಿ", mapX = 0.22f, mapY = 0.18f,
            storyPages = listOf(StoryPage("p1", storyLong, storyLongKn)),
            quiz = listOf(
                QuizQuestion("q1", "Who is the Queen of Kittur?", "ಕಿತ್ತೂರಿನ ರಾಣಿ ಯಾರು?", listOf("Kittur Chennamma", "Rani Lakshmi Bai", "Onake Obavva", "Belawadi Mallamma"), listOf("ಕಿತ್ತೂರು ಚೆನ್ನಮ್ಮ", "ರಾಣಿ ಲಕ್ಷ್ಮೀಬಾಯಿ", "ಒನಕೆ ಓಬವ್ವ", "ಬೆಳವಾಡಿ ಮಲ್ಲಮ್ಮ"), 0),
                QuizQuestion("q2", "Which empire did Kittur Chennamma fight against?", "ಕಿತ್ತೂರು ಚೆನ್ನಮ್ಮ ಯಾವ ಸಾಮ್ರಾಜ್ಯದ ವಿರುದ್ಧ ಹೋರಾಡಿದರು?", listOf("British East India Company", "Mughals", "Marathas", "French"), listOf("ಬ್ರಿಟಿಷ್ ಈಸ್ಟ್ ಇಂಡಿಯಾ ಕಂಪನಿ", "ಮೊಘಲರು", "ಮರಾಠರು", "ಫ್ರೆಂಚರು"), 0),
                QuizQuestion("q3", "Kittur Chennamma was the queen of which state?", "ಕಿತ್ತೂರು ಚೆನ್ನಮ್ಮ ಯಾವ ರಾಜ್ಯದ ರಾಣಿಯಾಗಿದ್ದರು?", listOf("Kittur", "Mysore", "Hyderabad", "Delhi"), listOf("ಕಿತ್ತೂರು", "ಮೈಸೂರು", "ಹೈದರಾಬಾದ್", "ದೆಹಲಿ"), 0)
            )
        ),
        Hero(
            id = "obavva", nameEn = "Onake Obavva", nameKn = "ಒನಕೆ ಓಬವ್ವ",
            titleEn = "Heroine of Chitradurga", titleKn = "ಚಿತ್ರದುರ್ಗದ ವೀರ ಮಹಿಳೆ",
            categoryEn = "Heroes", categoryKn = "ವೀರರು",
            coverImageUrl = "https://images.unsplash.com/photo-1533158307587-828f0a76cf46?q=80&w=800&auto=format&fit=crop",
            mascotUrl = "https://api.dicebear.com/7.x/micah/png?seed=obavva&backgroundColor=ffdfbf",
            regionEn = "Chitradurga", regionKn = "ಚಿತ್ರದುರ್ಗ", mapX = 0.45f, mapY = 0.5f,
            storyPages = listOf(StoryPage("p1", storyLong, storyLongKn)),
            quiz = listOf(
                QuizQuestion("q1", "What weapon did Onake Obavva use?", "ಒನಕೆ ಓಬವ್ವ ಯಾವ ಅಸ್ತ್ರವನ್ನು ಬಳಸಿದರು?", listOf("Onake (Pestle)", "Sword", "Bow", "Spear"), listOf("ಒನಕೆ", "ಕತ್ತಿ", "ಬಿಲ್ಲು", "ಈಟಿ"), 0),
                QuizQuestion("q2", "Which fort did she defend?", "ಅವಳು ಯಾವ ಕೋಟೆಯನ್ನು ರಕ್ಷಿಸಿದಳು?", listOf("Chitradurga", "Golconda", "Agra", "Red Fort"), listOf("ಚಿತ್ರದುರ್ಗ", "ಗೋಲ್ಕೊಂಡ", "ಆಗ್ರಾ", "ಕೆಂಪು ಕೋಟೆ"), 0),
                QuizQuestion("q3", "Whose army was attacking the fort?", "ಯಾರ ಸೈನ್ಯವು ಕೋಟೆಯ ಮೇಲೆ ದಾಳಿ ಮಾಡುತ್ತಿತ್ತು?", listOf("Hyder Ali", "British", "Marathas", "Portuguese"), listOf("ಹೈದರ್ ಅಲಿ", "ಬ್ರಿಟಿಷರು", "ಮರಾಠರು", "ಪೋರ್ಚುಗೀಸರು"), 0)
            )
        ),
        Hero(
            id = "abbakka", nameEn = "Rani Abbakka", nameKn = "ರಾಣಿ ಅಬ್ಬಕ್ಕ",
            titleEn = "Queen of Ullal", titleKn = "ಉಳ್ಳಾಲದ ರಾಣಿ",
            categoryEn = "Heroes", categoryKn = "ವೀರರು",
            coverImageUrl = "https://images.unsplash.com/photo-1523633589114-88eaf4b4f1a8?q=80&w=800&auto=format&fit=crop",
            mascotUrl = "https://api.dicebear.com/7.x/micah/png?seed=abbakka&backgroundColor=d1d4f9",
            regionEn = "Dakshina Kannada", regionKn = "ದಕ್ಷಿಣ ಕನ್ನಡ", mapX = 0.15f, mapY = 0.75f,
            storyPages = listOf(StoryPage("p1", storyLong, storyLongKn)),
            quiz = listOf(
                QuizQuestion("q1", "Rani Abbakka was the queen of?", "ರಾಣಿ ಅಬ್ಬಕ್ಕ ಎಲ್ಲಿಯ ರಾಣಿ?", listOf("Ullal", "Kittur", "Mysore", "Belagavi"), listOf("ಉಳ್ಳಾಲ", "ಕಿತ್ತೂರು", "ಮೈಸೂರು", "ಬೆಳಗಾವಿ"), 0),
                QuizQuestion("q2", "Who did Rani Abbakka fight against?", "ರಾಣಿ ಅಬ್ಬಕ್ಕ ಯಾರ ವಿರುದ್ಧ ಹೋರಾಡಿದರು?", listOf("Portuguese", "British", "French", "Dutch"), listOf("ಪೋರ್ಚುಗೀಸರು", "ಬ್ರಿಟಿಷರು", "ಫ್ರೆಂಚರು", "ಡಚ್ಚರು"), 0),
                QuizQuestion("q3", "What was Rani Abbakka known as?", "ರಾಣಿ ಅಬ್ಬಕ್ಕ ಅವರನ್ನು ಏನೆಂದು ಕರೆಯಲಾಗುತ್ತಿತ್ತು?", listOf("Abhaya Rani", "Kalyani", "Kittur Rani", "Jhansi Rani"), listOf("ಅಭಯ ರಾಣಿ", "ಕಲ್ಯಾಣಿ", "ಕಿತ್ತೂರು ರಾಣಿ", "ಝಾನ್ಸಿ ರಾಣಿ"), 0)
            )
        ),
        Hero(
            id = "kempegowda", nameEn = "Kempegowda", nameKn = "ಕೆಂಪೇಗೌಡ",
            titleEn = "Founder of Bengaluru", titleKn = "ಬೆಂಗಳೂರಿನ ನಿರ್ಮಾತೃ",
            categoryEn = "Heroes", categoryKn = "ವೀರರು",
            coverImageUrl = "https://images.unsplash.com/photo-1582510003544-4d00b7f74220?q=80&w=800&auto=format&fit=crop",
            mascotUrl = "https://api.dicebear.com/7.x/micah/png?seed=kempegowda&backgroundColor=ffdfbf",
            regionEn = "Bengaluru", regionKn = "ಬೆಂಗಳೂರು", mapX = 0.65f, mapY = 0.75f,
            storyPages = listOf(StoryPage("p1", storyLong, storyLongKn)),
            quiz = listOf(
                QuizQuestion("q1", "Who founded Bengaluru?", "ಬೆಂಗಳೂರು ನಿರ್ಮಾತೃ ಯಾರು?", listOf("Kempegowda", "Tipu Sultan", "Krishnadevaraya", "Shivaji"), listOf("ಕೆಂಪೇಗೌಡ", "ಟಿಪ್ಪು ಸುಲ್ತಾನ್", "ಕೃಷ್ಣದೇವರಾಯ", "ಶಿವಾಜಿ"), 0),
                QuizQuestion("q2", "Which empire was Kempegowda a chieftain under?", "ಕೆಂಪೇಗೌಡ ಯಾವ ಸಾಮ್ರಾಜ್ಯದ ಅಡಿಯಲ್ಲಿ ನಾಯಕರಾಗಿದ್ದರು?", listOf("Vijayanagara", "Mughal", "Maratha", "Maurya"), listOf("ವಿಜಯನಗರ", "ಮೊಘಲ", "ಮರಾಠ", "ಮೌರ್ಯ"), 0),
                QuizQuestion("q3", "What is Kempegowda's full name?", "ಕೆಂಪೇಗೌಡರ ಪೂರ್ಣ ಹೆಸರು ಏನು?", listOf("Nada Prabhu Kempegowda", "Raja Kempegowda", "Sultan Kempegowda", "Emperor Kempegowda"), listOf("ನಾಡಪ್ರಭು ಕೆಂಪೇಗೌಡ", "ರಾಜ ಕೆಂಪೇಗೌಡ", "ಸುಲ್ತಾನ್ ಕೆಂಪೇಗೌಡ", "ಚಕ್ರವರ್ತಿ ಕೆಂಪೇಗೌಡ"), 0)
            )
        ),
        Hero(
            id = "madakari", nameEn = "Madakari Nayaka", nameKn = "ಮದಕರಿ ನಾಯಕ",
            titleEn = "Ruler of Chitradurga", titleKn = "ಚಿತ್ರದುರ್ಗದ ದೊರೆ",
            categoryEn = "Heroes", categoryKn = "ವೀರರು",
            coverImageUrl = "https://images.unsplash.com/photo-1590418606746-018840f9cb25?q=80&w=800&auto=format&fit=crop",
            mascotUrl = "https://api.dicebear.com/7.x/micah/png?seed=madakari&backgroundColor=b6e3f4",
            regionEn = "Chitradurga", regionKn = "ಚಿತ್ರದುರ್ಗ", mapX = 0.48f, mapY = 0.52f,
            storyPages = listOf(StoryPage("p1", storyLong, storyLongKn)),
            quiz = listOf(
                QuizQuestion("q1", "Who was the ruler of Chitradurga during Hyder Ali's invasion?", "ಹೈದರ್ ಅಲಿಯ ಆಕ್ರಮಣದ ಸಮಯದಲ್ಲಿ ಚಿತ್ರದುರ್ಗದ ದೊರೆ ಯಾರು?", listOf("Madakari Nayaka", "Kempegowda", "Krishnadevaraya", "Tipu Sultan"), listOf("ಮದಕರಿ ನಾಯಕ", "ಕೆಂಪೇಗೌಡ", "ಕೃಷ್ಣದೇವರಾಯ", "ಟಿಪ್ಪು ಸುಲ್ತಾನ್"), 0),
                QuizQuestion("q2", "What is Chitradurga famous for?", "ಚಿತ್ರದುರ್ಗ ಯಾವುದಕ್ಕೆ ಪ್ರಸಿದ್ಧವಾಗಿದೆ?", listOf("Kallina Kote (Stone Fort)", "Palace", "Temple", "River"), listOf("ಕಲ್ಲಿನ ಕೋಟೆ", "ಅರಮನೆ", "ದೇವಾಲಯ", "ನದಿ"), 0),
                QuizQuestion("q3", "Madakari Nayaka fought bravely against whom?", "ಮದಕರಿ ನಾಯಕ ಯಾರ ವಿರುದ್ಧ ಧೈರ್ಯದಿಂದ ಹೋರಾಡಿದರು?", listOf("Hyder Ali", "British", "Portuguese", "Marathas"), listOf("ಹೈದರ್ ಅಲಿ", "ಬ್ರಿಟಿಷರು", "ಪೋರ್ಚುಗೀಸರು", "ಮರಾಠರು"), 0)
            )
        ),
        Hero(
            id = "visvesvaraya", nameEn = "Sir M. Visvesvaraya", nameKn = "ಸರ್ ಎಂ. ವಿಶ್ವೇಶ್ವರಯ್ಯ",
            titleEn = "Engineer & Statesman", titleKn = "ಮಹಾನ್ ಎಂಜಿನಿಯರ್",
            categoryEn = "Heroes", categoryKn = "ವೀರರು",
            coverImageUrl = "https://images.unsplash.com/photo-1521747116042-5a810fda9664?q=80&w=800&auto=format&fit=crop",
            mascotUrl = "https://api.dicebear.com/7.x/micah/png?seed=visvesvaraya&backgroundColor=c0aede",
            regionEn = "Chikkaballapur", regionKn = "ಚಿಕ್ಕಬಳ್ಳಾಪುರ", mapX = 0.7f, mapY = 0.65f,
            storyPages = listOf(StoryPage("p1", storyLong, storyLongKn)),
            quiz = listOf(
                QuizQuestion("q1", "What was Sir M. Visvesvaraya's profession?", "ಸರ್ ಎಂ. ವಿಶ್ವೇಶ್ವರಯ್ಯ ಅವರ ವೃತ್ತಿ ಏನು?", listOf("Civil Engineer", "Doctor", "Lawyer", "Teacher"), listOf("ಸಿವಿಲ್ ಇಂಜಿನಿಯರ್", "ವೈದ್ಯರು", "ವಕೀಲರು", "ಶಿಕ್ಷಕರು"), 0),
                QuizQuestion("q2", "Which famous dam did he design?", "ಅವರು ಯಾವ ಪ್ರಸಿದ್ಧ ಅಣೆಕಟ್ಟನ್ನು ವಿನ್ಯಾಸಗೊಳಿಸಿದರು?", listOf("KRS Dam", "Bhakra Nangal", "Hirakud", "Tungabhadra"), listOf("ಕೆಆರ್‌ಎಸ್ ಅಣೆಕಟ್ಟು", "ಭಾಕ್ರಾ ನಂಗಲ್", "ಹಿರಾಕುಡ್", "ತುಂಗಭದ್ರಾ"), 0),
                QuizQuestion("q3", "When is Engineer's Day celebrated in his honor?", "ಅವರ ಗೌರವಾರ್ಥವಾಗಿ ಇಂಜಿನಿಯರ್ಸ್ ಡೇ ಅನ್ನು ಯಾವಾಗ ಆಚರಿಸಲಾಗುತ್ತದೆ?", listOf("September 15", "October 2", "November 14", "August 15"), listOf("ಸೆಪ್ಟೆಂಬರ್ 15", "ಅಕ್ಟೋಬರ್ 2", "ನವೆಂಬರ್ 14", "ಆಗಸ್ಟ್ 15"), 0)
            )
        ),
        Hero(
            id = "mallamma", nameEn = "Belawadi Mallamma", nameKn = "ಬೆಳವಾಡಿ ಮಲ್ಲಮ್ಮ",
            titleEn = "Warrior Queen", titleKn = "ವೀರ ರಾಣಿ",
            categoryEn = "Heroes", categoryKn = "ವೀರರು",
            coverImageUrl = "https://images.unsplash.com/photo-1621252179027-94459d278660?q=80&w=800&auto=format&fit=crop",
            mascotUrl = "https://api.dicebear.com/7.x/micah/png?seed=mallamma&backgroundColor=ffdfbf",
            regionEn = "Belagavi", regionKn = "ಬೆಳಗಾವಿ", mapX = 0.28f, mapY = 0.22f,
            storyPages = listOf(StoryPage("p1", storyLong, storyLongKn)),
            quiz = listOf(
                QuizQuestion("q1", "Who formed a women's army in the 17th century?", "17ನೇ ಶತಮಾನದಲ್ಲಿ ಮಹಿಳಾ ಸೈನ್ಯವನ್ನು ಕಟ್ಟಿದವರು ಯಾರು?", listOf("Belawadi Mallamma", "Onake Obavva", "Kittur Chennamma", "Keladi Chennamma"), listOf("ಬೆಳವಾಡಿ ಮಲ್ಲಮ್ಮ", "ಒನಕೆ ಓಬವ್ವ", "ಕಿತ್ತೂರು ಚೆನ್ನಮ್ಮ", "ಕೆಳದಿ ಚೆನ್ನಮ್ಮ"), 0),
                QuizQuestion("q2", "Who did Belawadi Mallamma fight against?", "ಬೆಳವಾಡಿ ಮಲ್ಲಮ್ಮ ಯಾರ ವಿರುದ್ಧ ಹೋರಾಡಿದರು?", listOf("Shivaji", "British", "Portuguese", "Hyder Ali"), listOf("ಶಿವಾಜಿ", "ಬ್ರಿಟಿಷರು", "ಪೋರ್ಚುಗೀಸರು", "ಹೈದರ್ ಅಲಿ"), 0),
                QuizQuestion("q3", "What was she known for?", "ಅವರು ಯಾವುದಕ್ಕೆ ಪ್ರಸಿದ್ಧರಾಗಿದ್ದರು?", listOf("First woman to build a women's army", "Singing", "Painting", "Sculpting"), listOf("ಮಹಿಳಾ ಸೈನ್ಯವನ್ನು ಕಟ್ಟಿದ ಮೊದಲ নারী", "ಹಾಡುಗಾರಿಕೆ", "ಚಿತ್ರಕಲೆ", "ಶಿಲ್ಪಕಲೆ"), 0)
            )
        )
    )
}
