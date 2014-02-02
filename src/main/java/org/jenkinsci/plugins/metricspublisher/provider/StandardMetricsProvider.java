package org.jenkinsci.plugins.metricspublisher.provider;

import hudson.Extension;

import java.util.Arrays;
import java.util.List;

import org.jenkinsci.plugins.metricspublisher.Metric;

import jenkins.model.Jenkins;

@Extension
public class StandardMetricsProvider extends MetricsProvider
{
	@Override
	public List<Metric> provide()
	{
		return Arrays.asList(new Metric[] {
			new Metric("idleExecutors", Jenkins.getInstance().overallLoad.computeIdleExecutors()),
			new Metric("totalExecutors", Jenkins.getInstance().overallLoad.computeTotalExecutors())
		});
	}
}
