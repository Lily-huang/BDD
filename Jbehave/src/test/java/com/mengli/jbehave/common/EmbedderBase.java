package com.mengli.jbehave.common;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.EmbedderControls;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.ParameterConverters;
import org.jbehave.core.steps.ParameterConverters.DateConverter;
import org.jbehave.core.steps.SilentStepMonitor;

import java.text.SimpleDateFormat;

public class EmbedderBase extends Embedder {

	@Override
    public EmbedderControls embedderControls() {
        return new EmbedderControls().doIgnoreFailureInStories(true).doIgnoreFailureInView(true);
    }
 
	@Override
    public Configuration configuration() {
        Class<? extends EmbedderBase> embedderClass = this.getClass();
      //MostUsefulConfiguration使用默認的配置
        return new MostUsefulConfiguration()
        	//設置story文件的加載路徑
            .useStoryLoader(new LoadFromClasspath(embedderClass.getClassLoader()))
            //設定生成報告的相關配置
            .useStoryReporterBuilder(new StoryReporterBuilder()
                .withCodeLocation(CodeLocations.codeLocationFromClass(embedderClass))
                .withFormats(Format.CONSOLE, Format.TXT)
                .withCrossReference(new CrossReference()))
             //設定相關參數的轉換
            .useParameterConverters(new ParameterConverters()
                    .addConverters(new DateConverter(new SimpleDateFormat("yyyy-MM-dd")))) // use custom date pattern
            .useStepMonitor(new SilentStepMonitor());
    }
}
