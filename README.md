
##How to Run
You will have to check the code any way, so run this app (Parser has a main method)  from the command line 2 args:
 1. The path to the directory containing input file
 2. The path to the output directory.
 

##Quick explanation of what I did:

I seperated the code into 3 parts:
1. The File Line handler module:
    * Check _com.interview.file.field_ and its doc.
    * Only RecordRow is exposed for  line handling (extract field value from predefined length, validation rule...)
2. The Grouper module.
   * List of RecordModel(s) that is created by RecordRow  will be used to group by field value.
3. The Parser module:
   * Mostly file handling.


####Note: 
* Procedural approach is fine but when more field is added to the each line , it will be hard to maintain the code. With this, we just need to extend the Field class and link it to expected structure. 
* RecordGrouper can be refactored to accept key rather than give its fixed method to group. But it is out of scope of this project.
* Email me @ : trungtran140694@gmail.com  if you like the implementation and/or  test case request. Request for handling this project came quite late.
* resources folder has some file that can be used to test the code.

##Dependency used:
* apache-commons-io for quick file handling
* apache-commons-lang for quick string handling
* guava for quick file output format handling


