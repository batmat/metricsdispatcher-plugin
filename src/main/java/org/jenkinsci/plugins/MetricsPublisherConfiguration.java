package org.jenkinsci.plugins;

import java.util.ArrayList;
import java.util.List;

import org.jenkinsci.plugins.metricspublisher.Metric;
import org.jenkinsci.plugins.metricspublisher.provider.MetricsProvider;
import org.jenkinsci.plugins.metricspublisher.publisher.MetricsPublisher;

public class MetricsPublisherConfiguration
{
	private MetricsPublisherConfiguration()
	{
	}

	public static MetricsPublisherConfiguration getInstance()
	{
		return new MetricsPublisherConfiguration();
	}
	
	public List<Metric> getMetricsToPublish()
	{
		// TODO : create a more advanced data structure to prevent sending many metrics with the same name?
		List<Metric> metrics = new ArrayList<Metric>();
		for (MetricsProvider metricProvider : MetricsProvider.all())
		{
			for (Metric metric : metricProvider.provide())
			{
				metrics.add(metric);
			}
		}
		return metrics;
	}

	public List<MetricsPublisher> getPublishers()
	{
		return MetricsPublisher.all();
	}
}
