package org.jenkinsci.plugins.metricspublisher.publisher;

import hudson.ExtensionList;
import hudson.ExtensionPoint;

import java.util.List;

import jenkins.model.Jenkins;

import org.jenkinsci.plugins.metricspublisher.Metric;

public abstract class MetricsPublisher implements ExtensionPoint
{
	public abstract void publish(List<Metric> metrics);

	/**
	 * All registered {@link MetricsPublisher}
	 */
	public static ExtensionList<MetricsPublisher> all()
	{
		return Jenkins.getInstance().getExtensionList(MetricsPublisher.class);
	}
}
