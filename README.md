# Android Java reference

A reference Android project in Java for \
learning purposes for the course PMP(Programing for Mobile Platforms)

Generated with ```Empty activity``` for ```API 21: Android 5.0 Lollipop```.

# Notes

* Project structure
    ```
    app
        src
            main (the source code is placed here)
            res (xml and other resources that the application uses)
                drawable
                drawable-hdpi (situational-specific folder for screens with hdpi)
                layout
                layout-land (situational-specific folder for landscape layouts)
                values
                    strings.xml (GUI components can read text data to display from this file)
                values-mk (situational-specific folder for language specific values
                styles (for containign xml files with styles)
        build.gradle
    ```

* Activity represents one particular screen on which particular UI elements(called views) can be drawn

* Views - are the building blocks for building UI
    * ViewGroup subclass for layouts
    * other subclasses for widgets(buttons, text fields, images, etc)

* Events are used a lot in android programming
    * when view is clicked, touch gesture, data from request is received, timers

* For basic debugging, use ```Toast.makeText(this, "text", time).show()```
    * Toast is a short message displayed on the screen - used for non-essential information
    
* Usage findViewById
    * ```TextView tw = findViewById(R.id.idOfView)```

* Box model of widget:
    * content size
        * attributes ```layout_width``` and ```layout_height```, possible values in dp, ```match_parent``` or ```wrap_content```
    * padding
        * attributes ```padding```, ```paddingLeft```, ```paddingRight```, ```paddingBottom```, ```paddingTom```
    * border
    * margin
        * attributes ```layout_margin```, ```layout_marginLeft```, ```layout_marginRight```, ```layout_marginBottom```, ```layout_marginTom```

* XML files for describing layouts are placed in ```res/layout```

* Linear layout
    * basic viewGroup for horizontal or vertical placement of views
    * set ```gravity``` attribute to specify alignment direction for the whole layout
    * set ```layout_gravity``` attribute to specify alignment direction for the specific view
    * set ```weight``` attribute with value ```k``` to specify the fraction k/total of the total size of the layout 
    
* Grid layout
    * places views in grid cells
    * attributes ```android_rowCount``` and ```android_colCount```
    * attributes for vies ```layout_row``` and ```layout_col```

* Relative layout
    * places views relative to parent ViewGroup or other views
    * attributes set on views: ```layout_below```, ```layout_above```, ```layout_toLeftOf```, ```layout_toRightOf```

* Button view
    * key attributes: ```clickable```, ```id```, ```onClick```, ```text```

* ImageButton view
    * bonus attribute: ```src```

* ImageView
    * key attributes: ```id```, ```src```

* RadioButton view
    * need to be nested in RadioGroup ViewGrup
    * key attributes: ```checked```, ```clickable```, ```id```, ```onClick```, ```text```    

* Android apps can read data from internal and external storage

* Internal storage refers to the data that is private to each application

* One application cannot write to internal data storage of another application

* Some classes that are useful for reading and writing storage data
    * java.io.File
    * java.io.InputStream
    * java.io.OutputStream
    * java.util.Scanner
    * java.io.BufferedReader
    * java.io.PrintStream

* Some methods that Android provides to get file handles in internal storage
    * getFilesDir() - internal storage directory
    * getCacheDir() - temp directory
    * openFileInput("name", mode) - opens file for reading
    * openFileOutput("name", mode) - opens file for writing

* Some methods that Android provides to get file handles in external storage
    * getExternalFileDir()

* To use external storage, web data or camera the application needs to specify that it has to get permission from the system
    * that is done in ```AndroidManifest.xml```
    * ```xml
      <uses-permission
              android:name="android.permission.READ_EXTERNAL_STORAGE"/>
       <uses-permission
              android:name="android.permission.Write_EXTERNAL_STORAGE"/>
       <uses-permission
              android:name="android.permission.INTERNET"/>
       <uses-permission
              android:name="android.permission.CAMERA"/>
      ```
      
* ListView View
	* can contain list of selectable entries
	* key xml attributes:
		* android:clickable
		* android:entries
		* android:id

	* adapt list structure to ListView:
		* ```ArrayAdapter<String> lstAdapter = new ArrayAdapter<>(activity, layout, array)```
			* activity is usually ```this```
			* default layout for list item: ```android.R.layout.simple_list_item_1```
			* array: String[], ArrayList<String> etc

		* when data is changed in array, the ```AttayAdapter``` instance needs to be notified

	* events
		* setOnItemClickListener
		* setOnItemLongClickListener
		* setOnItemSelectedListener

	* custom layout
		* write short layout file
		* tell ArrayAdapter to use it and tell how to supply data to the layout

* RecyclerView
	* displays large set of data
	* recycles unused ViewHolders, so the method ```onBindViewHolder``` might be more used
	than ```OnCreateViewHolder```
	* key classes
		* RecyclerView
		* RecyclerView.ViewHolder
		* RecyclerView.Adapter
		* LayoutManager

* Activity lifecycle
    * onCreate()
    * onStart()
    * onRestoreSavedInstance() - when restoring from some hibernating state
    * onResume()
    * onSaveInstanceState()
    * onPause()
    * onStop()
    * when users goes back to activity
        * onRestart()
        * onStart()
        * and then the rest
    * onDestroy()
    
    * when we move across activities from one application \
    the lifecycle methods onPause() and onResume()
    
    * when we move to other applications the lifecycle methods onStop() and onRestart() are used
    
    * when the activity is destroyed and created the \
    lifecycle methods onDestroy() and onCreate() are used
    
* Intents are used to specify the desired action or activity to launch, \
can be thought of as bridge between activities.
    * they can store extra data to pass as parameters to activity
    * started activity can return data back to the caller
    * explicit intents start a particular activity
    * implicit intents specify a particular action that other application can handle
    
* Some concepts tied to activities
    * activity stack: activities are pushed and removed from stack \
    when one activity is started from another activity and that activity is closed
        * can set the parent activity explicitly
    * toolbar - a top level UI for menu of actions in activity
        * contain some actions, and other actions in a dropdown

* Check rotation state
    * ```java
      getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT
      ```

* Fragments are reusable segment of Android UI that is created always inside \
activity or other fragment.
    * can solve the problem with redundant layouts

* Fragments have similar lifecycle methods as activities with some additional
    * onAttach() - when fragment is glued to its surrounding activity
    * OnCreateView() - method that returns the view of the fragment
    * onActivityCreated() - method that indicates surrounding activity is ready
    * onDetach() - when fragment is being detached
    
* Fragments extends  the class```Fragment``` and must override the method ```onCreate```

* Fragments can access activity's data with ```getActivity()```
    * can also read the ```intent``` of that activity

* Fragments can communicate with other fragments that the activity contains using \
```getActivity().getFragmentManager().findFragmentById()```    

* Fragment's layout file can contain root element ```FrameLayout``` or any other layout
 
* On activity layout file, fragmens can be placed with the element ```<fragment>```
    * key attributes: 
        * ```id``` 
        * ```name``` is name of the fragment class
        
* Styles are placed inside ```styles``` project directory
    * define particular style with ```<style name="SomeName">...</style```
    * inside ```<style>``` define properties using \
     ```<item name="some view property">someValue</item>```
     
* Some types of dialogs:
    * ```AlertDialog```, ```CharacterPickerDialog```, ```DatePickerDialog```, \
    ```ProgressDialog```, ```TimePickerDialog```

* Parts of a dialog
    * Icon, title, message, negative button, positive button, neutral button
    
* Dialogs can be used 
    * by building with Builder(example ```AlertDialog.Builder``)
    * by creating custom dialogs
    
* Some libraries for android development
    * picasso - for loading images from internet and caching
    * butterknife - simplify usage of widgets
    * Espresso - powerful DSL for Android integration testing
    
* On 160 dpi screen, 1 dp == 1 pixel
    * on 320 dpi, 1 dp == 2 pixel
    * on 480 dpi, 1 dp == 3 pixel
    
* To check android version, use ```Build```
    * example ```Build.VERSION_SDK_INT```
    
* To check existence of device hardware
    * ```java
      PackageManager pm = getPackageManager();
      pm.hasSystemFeature(PackageManager.FEATURE_MICROPHONE);
      ```
      
* WebView - a view that displays web page

* Firebase
    * Backend-As-A-Service
    * built by SF-based Google subsidiary
    * cloud database
    * API to access data from Android, IOS, Java, Javascript 
    * REST API
    * receive notifications for data changes
    * cloud scaling
    * login/auth
    * database is represented as tree structure and map of key-value pairs
    
* Service in context of Android is a task that is running in background \
when started by an application.
    * example playing music or listening for new data changes
    
* Services are useful for long running tasks or providing functionality to other applications.

* Service lifecycle
    * startService()
    * onCreate()
    * onStartCommand()
    * onDestroy()
    
* Service classes extend the class ```Service```

* Parts of Notifications
    * large icon, small icon, content title, content text, content subtext, \
    actions, time, number of content info