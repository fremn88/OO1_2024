package ar.edu.unlp.info.oo1.ej10_jobScheduler;

public class JobSchedulerMostEffort extends JobSchedulerDami {

	public JobSchedulerMostEffort(String strategy) {
		super(strategy);
	}

	@Override
	public JobDescription nextJob() {
		return jobs.stream().max((j1, j2) -> Double.compare(j1.getEffort(), j2.getEffort())).orElse(null);
	}
}
