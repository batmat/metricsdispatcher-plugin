package org.jenkinsci.plugins.metricspublisher.publisher;

import hudson.Extension;

import java.util.List;

import org.jenkinsci.plugins.metricspublisher.Metric;

@Extension
public class SysoutPublisher extends MetricsPublisher
{
	@Override
	public void publish(List<Metric> metrics)
	{
		for (Metric metric : metrics)
		{
			System.out.println(metric);
		}
		System.out.println("The end\n");
	}
}
