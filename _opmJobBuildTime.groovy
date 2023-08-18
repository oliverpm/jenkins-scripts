def n=0
def num_notnull=0
def milliseconds_alljobs=0

Jenkins.instance.getAllItems(Job).each(){
  job -> job.isBuildable()   	
  def myBuild= job.getLastBuild()
  n = n + 1
    
  def last_job_duration = job.getLastBuild()?.getDurationString()
  def last_job_duration_milliseconds = job.getLastBuild()?.getDuration()
  println n + ".)" + "JOB " + job.getUrl() + " --------> " + last_job_duration + "; MilliSeconds:" + last_job_duration_milliseconds
  
  if(last_job_duration!=null){
    num_notnull = num_notnull + 1
    milliseconds_alljobs = milliseconds_alljobs + last_job_duration_milliseconds
  }
  	     
}
println "num_notnull = " + num_notnull + "; null = " + (n-num_notnull)
println "milliseconds_alljobs = " + milliseconds_alljobs
println "seconds_alljobs = " + (milliseconds_alljobs/1000)
println "seconds_average_alljobs = " + (milliseconds_alljobs/1000)/num_notnull
println "minutes_average_alljobs = " + ((milliseconds_alljobs/1000)/num_notnull)/60
println "hours_average_alljobs = " + (((milliseconds_alljobs/1000)/num_notnull)/60)/60
println "============================================================================================="
println "hours_alljobs = " + ((milliseconds_alljobs/1000)/60)/60


return null