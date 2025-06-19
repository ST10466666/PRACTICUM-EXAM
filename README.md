# PRACTICUM-EXAM
Music Playlist Manager 
A Kotlin-based Android app for managing a personal music playlist with the following features:
 Add songs (title, artist, rating, comments)
✅View playlist with all saved songs
 Calculate average song rating
 Clean exit with confirmation

  ## Installation
Clone the repo
Open in Android Studio

Run on emulator or device (Build → Run 'app'

## Features
Add up to 4 songs with details:
  - Song title
  - Artist name
  - Rating (1-5 stars)
  - Optional comments
- View complete playlist
- Calculate average song rating
- Clean exit with confirmation
  ## Screens
  ### Main Screen
  ![main screen](https://github.com/user-attachments/assets/7e3e90d7-eb97-49c8-8d40-f74a1e77c90a)

  This is the primary screen of your music playlist app where users can:

Add songs to their playlist (up to 4 songs max)

View their playlist (navigates to a second screen)

Exit the app

### UI Components
Three Buttons (defined in activity_main.xml):

Enter Button (enterButton): Opens a dialog to input song details

Click Button (clickButton): Navigates to the playlist view screen

Exit Button (exitAppButton): Closes the app with confirmation

Data Storage (4 parallel arrays):

titles: Stores song names (e.g., "Burning Blue")

artists: Stores artist names (e.g., "Mariah the Scientist")

ratings: Stores ratings (1-5)

comments: Stores optional user comments

count: Tracks how many songs are currently stored (0-4) 

### User Flow Example
User taps Enter Button

Enters:

Title: "Easy on Me"

Artist: "Adele"

Rating: 4

Comment: "Great vocals!"

Clicks "Add" → song saves to playlist

Repeats until 4 songs added

Taps Click Button to view full playlist

Can return and keep adding songs until limit reached

Taps Exit Button to quit when done

## Detailed View Screen
![Detailed view screen](https://github.com/user-attachments/assets/14bfcf1b-baf3-4266-9d44-eebbca772133)

 ### Core Purpose
Displays all songs added from the main screen

Shows calculated average rating

Provides a clean summary view of the playlist

### UI Components
Single TextView (playlistTextView):

Displays all songs in formatted layout

Shows each song's details in clear sections

Includes visual separators between songs

Back Button (backButton):

Returns user to main screen

Maintains all existing playlist data

Data Display:

Shows 4 key details per song:

Title (e.g., "Burning Blue")

Artist (e.g., "Mariah the Scientist")

Rating (1-5 stars)

Comment (user remarks)

Displays average rating of all songs at bottom

### Key Features
1. Playlist Rendering
Triggered by: Intent from MainActivity

What it does:

Receives 4 parallel arrays + song count

Formats each song entry with consistent spacing

Handles empty playlist case gracefully

Uses scrolling for overflow content

2. Average Rating Calculation
Automatic computation:

Sums all ratings

Divides by number of songs

Displays with 2 decimal places (e.g., "4.25")

3. Navigation Control
Back Button:

Simple finish() operation

Preserves all data in MainActivity's arrays

No data loss during navigation

![main screen running](https://github.com/user-attachments/assets/08a4ae51-64df-40bb-8b94-a026f2a67332)

**Add playlist Button**: Add new songs
- **Next page Button**: View playlist
- **ExitApp Button**: Close app
- This is the mai screen running

  
  ![detailed screen running](https://github.com/user-attachments/assets/9fb08014-7e5a-4d07-b88d-0533c4c64ec5)
  - Displays all saved songs
- Calculates and shows average rating
- Formats playlist display
- This is the Detailed screen running
- This is the detailed view screen running

  ## Source Codes
  ![mainscreen code](https://github.com/user-attachments/assets/455800c9-c4ea-46c3-a949-a8c6038f4e89)
 
  ### Core Responsibilities
Handles user input for song details
Manages data storage in memory
Controls navigation to playlist screen
Uses parallel arrays for data organization
count tracks number of songs added (0-4)
Dynamic dialog creation with custom layout
Input validation before storing data
Ensures required fields are provided
Validates rating range (1-5 stars)
Intent-based navigation with data transfer
Clean app exit with user confirmation

  ![detailed view screen code](https://github.com/user-attachments/assets/417680cc-f92c-4795-8e99-a354b5163092)
  ### Core Responsibilities
Displays formatted playlist
Calculates average rating
Handles back navigation
Safely extracts data from MainActivity
Uses null-coalescing for empty cases
StringBuilder for efficient text construction
Conditional comment display
Clear visual separation between songs
 Layout Files
activity_main.xml
Contains three buttons:
enterButton (Add songs)
clickButton (View playlist)
exitAppButton (Close app)
activity_main2.xml
ScrollView wrapper for long lists
TextView for playlist display
Back button for navigation
 dialog_add_song.xml
Text fields for:
Song title (etSongTitle)
Artist name (etArtistName)
Rating (etRating)
Comments (etComment)


  ## Technical Details
 Minimum Requirements
Android 5.0+ (API 21)

Kotlin 1.6+

 Dependencies
AndroidX AppCompat (Standard Android support)

Material Design Components (UI elements)

 Known Limitations
Data not saved between app launches

No edit/delete functionality

Fixed 4-song limit

 ## License
This project is licensed under MIT License.

## 

  


  
  

  


