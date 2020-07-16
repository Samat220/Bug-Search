CS622, Final Exam, Ramazan Samat

This final exam asked me to put bug picture into chicken picture and
test my algorithm for searching bug position.
This app doesn't include any GUI.

I have used https://docs.oracle.com/javase/tutorial/2d/images/index.html
explanations and modules in order to achieve the goal.

How to run:
Make sure that you have Bug picture and Chicken with bug picture in the same folder,
and that the file names correspond with the code (including .png)

This app creates 5 for loops that check each pixel in checken picture for
each pixel in bug picture. This operation may take very long time depending
on the position of the bug.

This Application includes two methods
Overlay() and ReadImage()
Overlay() method reads two images: "Bug Final.png" and "Chickens clean.png"
User inputs X and Y coordinates, application nests bug into the clean chicken.
Then system will look for the bug and will find it on the coordinates that user chose.


ReadImage() reads the image file that user wants to check for the bug.

In order to choose the Overlay() method, please change Boolean method 1 to true 
in the LoadImageApp class 

In order to choose the ReadImage() method, please change Boolean method 1 to false 
in the LoadImageApp class 