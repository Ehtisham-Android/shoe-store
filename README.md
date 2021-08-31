# The Shoe Store

This project will consist of five screens. You don't have to create a shoe store, you can use any other item as long as you create the following screens. You will be creating:

1. Login screen: Email and password fields and labels plus create and login buttons (Done)
2. Welcome onboarding screen (Done)
3. Instructions onboarding screen (Done)
4. Shoe Listing screen (Done)
5. Shoe Detail screen for adding a new shoe (Done)

## Getting Started

Open the starter project in the latest stable version of Android Studio. (Done)

Open the starter project in Android Studio (Done)

##Steps

1. Open the starter project in Android Studio (Done)

2. Add the navigation libraries to the app build.gradle file (Done)

3. Add the safe-arg plugin to the main and app build.gradle file (Done)

4. Create a new navigation xml file (Done)

5. Create a new Login destination. (Done)

   * Include email and password labels (Done)

   - Include email and password fields (Done)
   - Create buttons for creating a new login and logging in with an existing account (Done)
   - Clicking either button should navigate to the Welcome Screen. (Done)

6. Create a new Welcome screen destination that includes: (Done)

   * A new layout (Done)
   * At least 2 textviews (Done)
   * A navigation button with actions to navigate to the instructions screen (Done)

7. Create a new Instruction destination that includes: (Done)

   * A new layout (Done)
   * At least 2 textviews (Done)
   * A navigation button with actions to navigate to the shoe list screen (Done)

8. Create a class that extends ViewModel (Done)

   *  Use a LiveData field that returns the list of shoes (Done)

9. Create a new Shoe List destination that includes: (Done)

   * A new layout (Done)
   * A ScrollView (Done)
   * A LinearLayout for Shoe Items (Done)
   * A FloatingActionButton with an action to navigate to the shoe detail screen (Done)

10. In MainActivity, setup the nav controller with the toolbar and an AppBarConfiguration. (Done)

11. Create a new Shoe Detail destination that includes: (Done)

    * A new layout (Done)
    * A TextView label and EditView for the (Done)
      * Shoe Name (Done)
      * Company (Done)
      * Shoe Size (Done)
      * Description (Done)
    * A Cancel button with an action to navigate back to the shoe list screen (Done)
    * A Save button with an action to navigate back to the shoe list screen and add a new Shoe to the Shoe View Model (Done)

12. Make sure you can’t go back to onboarding screens (Done)

13. In the Shoe List screen: (Done)

    * Use an Activity level ViewModel to hold a list of Shoes (use by activityViewModels) (Done)
    * Observe the shoes variable from the ViewModel (Done)
    * Use DataBindingUtil to inflate the shoe_list layout (Done)
    * Add a new layout item into the scrollview for each shoe. (Done)