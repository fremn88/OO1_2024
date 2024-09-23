package ar.edu.unlp.info.oo1.ej10_jobScheduler;

import java.util.ArrayList;
import java.util.List;

public abstract class JobSchedulerDami {

	protected List<JobDescription> jobs;
	protected String strategy;

	public JobSchedulerDami(String strategy) {
		this.jobs = new ArrayList<>();
		this.strategy = strategy;
	}

	public void schedule(JobDescription job) {
		this.jobs.add(job);
	}

	public void unschedule(JobDescription job) {
		if (job != null) {
			this.jobs.remove(job);
		}
	}

	public String getStrategy() {
		return this.strategy;
	}

	public List<JobDescription> getJobs() {
		return jobs;
	}

	public void setStrategy(String aStrategy) {
		this.strategy = aStrategy;
	}

	protected abstract JobDescription next();
}
