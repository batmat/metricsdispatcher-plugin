package org.jenkinsci.plugins.metricspublisher;

import hudson.Extension;
import hudson.model.PeriodicWork;

import java.util.List;

import org.jenkinsci.plugins.MetricsPublisherConfiguration;
import org.jenkinsci.plugins.metricspublisher.publisher.MetricsPublisher;

@Extension
public class PublishMetricsPeriodicWork extends PeriodicWork
{
	@Override
	public long getRecurrencePeriod()
	{
		return 5000;
	}

	@Override
	protected void doRun() throws Exception
	{
		System.out.println("Periodic Run !!!");

		List<Metric> metricsToPublish = MetricsPublisherConfiguration.getInstance().getMetricsToPublish();

		List<MetricsPublisher> all = MetricsPublisherConfiguration.getInstance().getPublishers();

		System.out.println("Got " + all.size() + " publishers !");
		for (MetricsPublisher publisher : all)
		{
			System.out.println(publisher.getClass());
			publisher.publish(metricsToPublish);
		}
	}
}
