package ar.edu.unlp.info.oo1.ej10_jobScheduler;

public class JobSchedulerPriority extends JobSchedulerDami {
	
	// hace falte???
	public JobSchedulerPriority(String strategy) {
		super(strategy);
	}

	@Override
	public JobDescription next() {
        JobDescription nextJob = jobs.get(0);
        nextJob = jobs.stream()
                .max((j1,j2) -> Double.compare(j1.getPriority(), j2.getPriority()))
                .orElse(null);
            this.unschedule(nextJob);
            return nextJob;
	}
}
