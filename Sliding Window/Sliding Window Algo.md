### Sliding Window Algorithm Steps

#### Imagine a Line of Windows:
Think of a row of windows on a wall. Now, imagine you have a camera that can take a picture of a few windows at a time.

#### What Are We Looking For?
Suppose you have numbers written on paper stuck to each window, and you want to find something special in every set of windows you take a picture of. For example, let's find the first negative number in each set of windows.

#### How Many Windows in a Set?
Decide how many windows you want in each picture (let's say 3 windows at a time).

#### Slide and Snap
Start at the beginning and take a picture of the first 3 windows.  
Note down the first negative number you see in the picture. If there isn't one, note 0.

#### Move Over
Slide your camera one window to the right and take another picture of the next 3 windows.  
Again, note down the first negative number you see, or 0 if there isn't one.

#### Repeat
Keep sliding your camera one window to the right and snapping pictures until you reach the end of the row.

#### Write Down Your Findings
Once you've looked at all sets of windows, you'll have a list of first negative numbers (or 0's if there were none) for each set.
