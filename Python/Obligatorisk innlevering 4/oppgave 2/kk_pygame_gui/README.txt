READE ME:


THE MODULS AND FUNCTIONS:


#SCREEN
   - Needed to make a screen and contain all other moduls. 
	- When one of the items are used(triggered), the screen variable triggered will be True
              - When triggered is True, screen.value with contain a dictionary of all the info about the triggered object.
              - {"hover":False, "triggered":False, "id":False, "content":False, "type":False}

   - When creating one you can change:

	- width/height:
	     -> Default is 500
	     -> Cannot be changed afterwards
	- FPS:
	     -> Maximun FPS for app.
	     -> Default is 60  
	     -> Cannot be changed afterwards  
	- title:
	     -> The text displayed in the app-banner.
	     -> Default text: "Application"
	- background_color:
	     -> Default: (255, 255, 255)
        - show_fps:
	     -> Shows the current FPS next to the banner title.
	     -> True or False
	- resizable:
             -> Make the screen resizable
             -> centered items will stay centered
             -> True or False
        - center_items:
	     -> True or False
             -> Will center all items vertically and horizontally
             -> Multiple items will by default be in a vertical row
        - direction:
             -> All items will be placed in a verical row or horizontal row
             -> Default: 1
             -> [0, "hor", "horizontal"] or [1, "vert", "vertical"]

   - Functions:
	- .add()
             -> Adds other moduls(buttons etc) into the screen.
	     -> Can add multiple things (*args)
        - .center()
             -> If cener_items is True, but you make changes to the screen and items are not centered, use this.
        - .prompt_file()
             -> Will pause the screen loop and open a file window.
             -> The path to the file you choose will be returned
        - .write_file()
	     -> Takes name and string content and makes a txt file.
	     -> Default filename="text_file.txt", content="")
        - .read_file()
	     -> Takes file name and reads it.
	     -> It returns the content as a string



#Flexbox
#Button
#Switch
#Slider
#Text
#Input



