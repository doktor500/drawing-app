### Requirements

- Java 8+

### Run tests

    ./gradlew test

### Build the app

    ./gradlew buildApp

### Run the app

    java -jar ./build/libs/drawing.jar

### Description of the problem

You're given the task of writing a simple console version of a drawing program.
The functionality of the program is quite limited but should be extensible. The program should work as follows:

1. create a new canvas.
2. start drawing on the canvas by issuing various commands. 
3. quit.

The program should support the following commands:

|Command|Description|
|---|---|
|`C w h`| Should create a new canvas of width w and height h. |
|`L x1 y1 x2 y2`| Should create a new line from (x1,y1) to (x2,y2). Currently only horizontal or vertical lines are supported. Horizontal and vertical lines will be drawn using the `x` character. |
|`R x1 y1 x2 y2`| Should create a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2) . Horizontal and vertical lines will be drawn using the `x` character. |
|`B x y c`|   Should fill the entire area connected to (x,y) with colour `'c'`. The behaviour of this is the same as that of the "bucket fill" tool in paint programs. |
|`Q`| Should quit the program. |

**Sample I/O**

Below is a sample of the output your program should produce. User input is prefixed with enter command:

    enter command:
    C 20 4
    ----------------------
    |                    |
    |                    |
    |                    |
    |                    |
    ----------------------
    enter command:
    L 1 2 6 2
    ----------------------
    |                    |
    |XXXXXX              |
    |                    |
    |                    |
    ----------------------
    enter command:
    L 6 3 6 4
    ----------------------
    |                    |
    |XXXXXX              |
    |     X              |
    |     X              |
    ----------------------
    enter command:
    R 16 1 20 3
    ----------------------
    |               XXXXX|
    |XXXXXX         X   X|
    |     X         XXXXX|
    |     X              |
    ----------------------
    enter command:
    B 10 3 o
    ----------------------
    |oooooooooooooooXXXXX|
    |XXXXXXoooooooooX   X|
    |     XoooooooooXXXXX|
    |     Xoooooooooooooo|
    ----------------------
    enter command:
    Q

### Used libraries

I decided to use [picocli](https://picocli.info/) to deal with the command line interface and process input commands
since I didn't want to reinvent the wheel and it provides a simple API that does the job.

PicoCLI will prompt a message if the user does not type the right command with some useful guidelines.

### Edge cases

I am not doing domain validations, for instance, if the user tries to draw a line without creating a canvas first,
the app won't crash and degrade gracefully, but it won't tell the user that a canvas needs to be created first.

Domain validations that could be included:

- Validate that a canvas has size greater or equal to 1, or show an error to the user otherwise
- Validate that a canvas exist before performing any other operation, or show an error to the user otherwise
- Validate that valid lines are always straight, since right now it will fill a rectangle if a diagonal line is used
- Validate that a shape fits within the canvas, since right now it will add the shape partially to it
- Etc.

### Conventions followed

I tried to use a functional style wherever possible. The only mutations of data that are happening within the app are in
DrawingApp class, which is the edge of the application.

I tried to follow DDD guidelines like using the ubiquitous language by naming the domain entities based on the
information that I could extract from the exercise description.

I also tried to apply some concepts of clean or hexagonal architecture, like having a core domain that doesn't have
dependencies on anything else, presentation logic is extracted out in a trait. 
I also created infrastructure and application packages accordingly.

