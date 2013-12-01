This is a wacky experiment to hash out what's necessary to create some views. 

I had some specific needs, a TabHost within a ViewStub, which contained ViewStubs, when
inflated became ViewPagers. I also didn't want to use fragments for this, so this is all
done with normal views, and it should be a fairly lightweight strategy. I populated it 
with a bunch of images, so those will chew up quite a bit of heap space, but the app should 
launch quickly, and be generally responsive. 

There are no dependencies, and no permissions used for this. [Here's a walk-through of some
of this code](http://www.recursiverobot.com/post/53884541941/viewpager-inside-a-viewstub-inside-a-tabhost-inside-a).

By <a href="plus.google.com/u/0/110693175237378228684?rel=author">E John Feig</a>
