package ar.edu.unlp.info.oo1.ej10_jobScheduler;

public class JobSchedulerFIFO extends JobSchedulerDami {

	public JobSchedulerFIFO(String strategy) {
		super(strategy);
		// TODO Auto-generated constructor stub
	}

	protected JobDescription nextJob() {
		return jobs.get(0);
	}
}
