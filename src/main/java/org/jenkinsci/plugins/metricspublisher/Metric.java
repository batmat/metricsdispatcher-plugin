package org.jenkinsci.plugins.metricspublisher;

public class Metric
{
	private final String name;

	private final float value;

	private final String description;

	public Metric(String name, int value)
	{
		this(name, value, "");
	}

	public Metric(String name, int value, String description)
	{
		this.name = name;
		this.value = value;
		this.description = description;
	}

	public float getValue()
	{
		return value;
	}

	public String getName()
	{
		return name;
	}

	public String getDescription()
	{
		return description;
	}

	@Override
	public String toString()
	{
		return name + " -> " + value + " (" + description + ")";
	}
}
