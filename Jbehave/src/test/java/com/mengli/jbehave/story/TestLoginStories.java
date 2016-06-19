package com.mengli.jbehave.story;

import com.mengli.jbehave.common.EmbedderBase;
import com.mengli.jbehave.step.TestLoginStep;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

/**
 * Created by mlhuang on 6/19/16.
 */
public class TestLoginStories extends EmbedderBase {

    @Override
    public InjectableStepsFactory stepsFactory()
    {
        return new InstanceStepsFactory(configuration(),new TestLoginStep());
    }
}
