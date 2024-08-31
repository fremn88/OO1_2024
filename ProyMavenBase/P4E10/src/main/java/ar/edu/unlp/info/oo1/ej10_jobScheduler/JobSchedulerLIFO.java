package ar.edu.unlp.info.oo1.ej10_jobScheduler;

public class JobSchedulerLIFO extends JobSchedulerDami {
	
	// hace falte???
	public JobSchedulerLIFO(String strategy) {
		super(strategy);
	}

	@Override
	public JobDescription next() {
        JobDescription nextJob = jobs.get(0);
        nextJob = jobs.get(jobs.size()-1);
        this.unschedule(nextJob);
        return nextJob;
	}
}
