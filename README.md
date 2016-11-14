# OOP_BouncingBall
A small application I made in Java/Netbeans to display a bunch of bouncing balls in a swing field.

This was done for my Object Oreinted Class at Texas A&M University at Corpus Christi,(90044.201609 [FALL-16] COSC-3324-001)

Here is the prompt, copied from the class instructions on https://bb9.tamucc.edu/webapps/blackboard/content/listContent.jsp?course_id=_52752_1&content_id=_1986651_1

1. Write a program that bounces a blue ball inside a JPanel. The ball should begin moving with a mousePressed event. When the ball hits the edge of the JPanel, it should bounce off the edge and continue in the opposite direction. The ball should be updated using a Runnable.

2. A new ball should be added each time the user clicks the mouse. The program should support creation up to 20 balls. Randomly choose the color for each new ball yet make the initial ball a blue one.

3. Pressing space should pause the movement. To continue moving the balls you should press space again.

Good Luck!


Issues:

I misread the instructions and unfortunately made it so one could spawn as many balls as they wanted until they run out of ram.
I'm not entirely sure that's a serious issue, as it is handled pretty well and it takes a considerable amount of time to reach that point

Version history:

Alpha 1.0 release: 
Initial release. Contains the following feature set:
  -Full JFrame functionality, including the abilty to close the window by clicking the close Icon
  -Resizable window, with bouncing bounds adjusted accordingly
  -Ability to create "Ball" object on mouse click
  -"Ball" creation happens at mouse location
  -"Ball"s are generated with randomized speed, radius, and color
  -Ability to pause on spacebar
  -Pausing spawns a small JDialog Box telling the user that they have indeed paused the game
  -Upon exit of JDialog box game resumes
Issues:
  -Only way to close JFrame is by clicking the close Icon (ALT+F4 support is wonky)
  -Pause Menu is lackluster with little functionality
