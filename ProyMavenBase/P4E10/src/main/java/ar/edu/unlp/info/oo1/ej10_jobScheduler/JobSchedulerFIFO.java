package ar.edu.unlp.info.oo1.ej10_jobScheduler;

public class JobSchedulerFIFO extends JobSchedulerDami {

	// hace falte???
	public JobSchedulerFIFO(String strategy) {
		super(strategy);
	}

	@Override
	public JobDescription next() {
        JobDescription nextJob = jobs.get(0);
        this.unschedule(nextJob);
        return nextJob;
	}
}
