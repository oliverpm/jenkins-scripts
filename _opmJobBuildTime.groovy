def n=0
def num_notnull=0
def miliseconds_alljobs=0

Jenkins.instance.getAllItems(Job).each(){
  job -> job.isBuildable()   	
  def myBuild= job.getLastBuild()
  n = n + 1
    
  def last_job_duration = job.getLastBuild()?.getDurationString()
  def last_job_duration_miliseconds = job.getLastBuild()?.getDuration()
  println n + ".)" + "JOB " + job.getUrl() + " --------> " + last_job_duration + "; MilSeconds:" + last_job_duration_miliseconds
  
  if(last_job_duration!=null){
    num_notnull = num_notnull + 1
    miliseconds_alljobs = miliseconds_alljobs + last_job_duration_miliseconds
  }
  	     
}
println "num_notnull = " + num_notnull + "; null = " + (n-num_notnull)
println "miliseconds_alljobs = " + miliseconds_alljobs
println "seconds_alljobs = " + (miliseconds_alljobs/1000)
println "seconds_average_alljobs = " + (miliseconds_alljobs/1000)/num_notnull
println "minutes_average_alljobs = " + ((miliseconds_alljobs/1000)/num_notnull)/60
println "hours_average_alljobs = " + (((miliseconds_alljobs/1000)/num_notnull)/60)/60
println "============================================================================================="
println "hours_alljobs = " + ((miliseconds_alljobs/1000)/60)/60


return null