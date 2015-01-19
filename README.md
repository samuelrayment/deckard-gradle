# Deckard (for Gradle)

Robolectric JUnit and Espresso 2.0 tests running in an example app.

### Running the Robolectric Test
You should now be able to `DeckardActivityRobolectricTest`. Run it as a normal JUnit test - make sure to choose the JUnit test runner and not the Android one.
 
### Running the Espresso Test
To run the Espresso test, you need to set up a Run Configuration. Go to `Edit Configurations -> Defaults -> Android Tests` and, after choosing  the correct module (deckard-gradle), fill in the `Specific instrumentation test runner` field. The easiest way is to click the ellipsis button on the right and type in `GITR`. This will find `GoogleInstrumentationTestRunner`, which is what you want. The fully-qualified class name will appear. Now you can right click on the test method in `DeckardEspressoTest` and choose the Android test runner.
