package com.mengli.jbehave.test;

import com.mengli.jbehave.story.TestLoginStories;
import com.mengli.jbehave.story.TestLogoffStories;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by mlhuang on 6/19/16.
 */
public class TestStoryRunner{
    @Test(groups = {"test"})
    public void runClasspathLoadOfTestLoginStory()
    {
        Embedder embedder=new TestLoginStories();
        List<String> storyPaths=new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()),"**/TestLoginStories.story","");
        embedder.runStoriesAsPaths(storyPaths);
    }

    @Test(groups = {"test"})
    public void runClasspathLoadOfTestLogoffStory()
    {
        Embedder embedder=new TestLogoffStories();
        List<String> storyPaths=new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()),"**/TestLogoffStories.story","");
        embedder.runStoriesAsPaths(storyPaths);
    }
}
