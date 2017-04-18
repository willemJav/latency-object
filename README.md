A LatencyObject singletonclass will collect latency-data for a file/zip creating web application. 
Random words of various characters will be created into a text-file of 1000 lines. 
Each line will harbor various words with a maximum of 75 characters. Five copies of 
the 1000 line textfile will be saved at a newly created folder: C:/textfolder/ under 
the name of randomtext1-5.txt. Next zip-file will be created by zipping the five previous created text-file in a file called: 
randomtextZip at the same folder.
The focus of this project is to measure the latency of all components of the project
1.	word
2.	line (75 characters)
3.	text (1000 line)
4.	text copied into 5 equal textfiles
5.	a zip of the 5 files
6.	showing the result at a web-page (servlet)

The collected data will be saved into a LatencyObject and a LatencyService class will make all the data available. The duration of the ResultServlet will also be measured by the use of an servlet-filter class.

