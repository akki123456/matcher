I have built an maven project using Java and Spring boot.
Url format for accessing the 'matches' API:
http://localhost:8080/swipejobs/matcher/matches/{workerId}

There are two aspects to the problem namely Filtering and Sorting.

Filters:
Filters are the minimum criterian required for a worker to be eligible for the job. Workers who dont meet criteria will not see those jobs
While evaluating filters, the evaluations are also added to the jobs to be used later on while sorting. for e.g. distance calculated is used for both filtering 
(job must not be farther than the maximum distance)and sorting(all the filtered jobs could be sorted with the nearest first).
New filters can be added by implementing Filter interface and autowired through FilterConfiguration class

Sorting:
Sorting is done by evaluating a score. Each scorecalculator is associated with an attribute. 
For this solution I have taken a linear approach with mapping all the values between max and min value in a zero to maxscore range. 
Each scorecalculator has its own maxscore. The bigger the maxscore the more the weightage that attribute has on total score.
The maxscore mapping of scores can be done through ScoreChainConfiguration class.


