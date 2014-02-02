package org.jenkinsci.plugins.metricspublisher.provider;

import hudson.ExtensionList;
import hudson.ExtensionPoint;

import java.util.List;

import org.jenkinsci.plugins.metricspublisher.Metric;

import jenkins.model.Jenkins;

public abstract class MetricsProvider implements ExtensionPoint
{
	public static ExtensionList<MetricsProvider> all()
	{
		return Jenkins.getInstance().getExtensionList(MetricsProvider.class);
	}

	public abstract List<Metric> provide();
}
