Chapter 1 - File Copy Example
=======================

This example is copying files from data/inbox to data/outbox directory.

I've modified this example to copy websites into the output directory. Previously it copied files from one directory to another. I was curious if the URI format for the files would be consistent for local and remote files.

What I discovered is that you cannot use HTTP as a producer in the same way that the example had been used the `file://` protocol. First off, HTTP is not implemented in camel-core. I had to take a separate dependency on camel-http. Furthermore, the example would not allow me to use the remote location as a producer. I suspect that this is because under the hood the `file://` protocol is using inotify, which has no analog over HTTP. Instead I used a timer as the producer and pulled the website every one second. This example demonstrates the difference between synchronous and asynchronous receivers discussed in the book.


Running
-----------

To run the example:

    mvn compile exec:java -Dexec.mainClass=camelinaction.WebsiteCopier
    
When the example is done, you can see that 10 copies of google.com have been copied into `data/outbox`.
