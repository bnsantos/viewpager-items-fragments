# viewpager-items-fragments
ViewPager with items as Fragments and on has ChildFragments

Adding inner fragments using ```getFragmentManager()``` to do the transaction, every time you go back to that adapter you'll see the fragment without the inner one and if you click in the button a new fragment is going to be created. Generating a memory leak.
To checkout the memory leak just checkout the tag ```problem``` 
1.  run
2.  do a garbage collection 
3.  dump memory heap
4.  export as standard .hprof
5.  analyse on eclipse MAT

###### References
https://github.com/danilao/fragments-viewpager-example
http://www.androiddesignpatterns.com/2013/08/fragment-transaction-commit-state-loss.html
https://medium.com/@elsenovraditya/android-hunting-memory-leak-in-nested-fragments-inside-viewpager-fc1879904804#.xfrxw1fmi
https://github.com/elsennov/MemoryLeakViewPager
https://medium.com/@elsenovraditya/android-hunting-memory-leak-in-nested-fragments-inside-viewpager-fc1879904804#.bvobpx9ib
