package ar.edu.unlp.info.oo1.ej10_jobScheduler;

public class JobSchedulerLIFO extends JobSchedulerDami {

	public JobSchedulerLIFO(String strategy) {
		super(strategy);
	}

	@Override
	public JobDescription nextJob() {
		return jobs.get(jobs.size() - 1);

	}
}
