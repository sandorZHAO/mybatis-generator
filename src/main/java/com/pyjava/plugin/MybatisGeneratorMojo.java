package com.pyjava.plugin;

import com.pyjava.plugin.generator.MybatisGenerator;
import lombok.extern.slf4j.Slf4j;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.apache.maven.project.MavenProject;

import java.io.File;

/**
 * 作为mybatis生成器的插件入口实现类
 *
 * @author zhaojj9
 * @since 1.0.0
 */
@Slf4j
@Mojo(name = "mybatis-generator", defaultPhase = LifecyclePhase.GENERATE_SOURCES, requiresDependencyResolution = ResolutionScope.TEST)
public class MybatisGeneratorMojo extends AbstractMojo {

    @Parameter(property = "project", required = true, readonly = true)
    private MavenProject project;

    @Parameter(property = "generator.mybatis.outputDirectory", defaultValue = "${project.build.directory}/generated-sources/generator", required = true)
    private File outputDirectory;

    @Parameter(property = "generator.mybatis.configurationFile", defaultValue = "${project.basedir}/src/main/resources/generator.properties", required = true)
    private File configurationFile;

    @Parameter(property = "generator.skip", defaultValue = "false")
    private boolean skip;

    @Parameter(property = "debug", defaultValue = "false")
    private boolean debug;

    /**
     * 处理器入口
     *
     * @throws MojoExecutionException mojo处理异常
     * @throws MojoFailureException   mojo失败异常
     */
    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        MybatisGenerator mybatisGenerator = new MybatisGenerator(debug, project, configurationFile);
        mybatisGenerator.init();
        mybatisGenerator.service();
        mybatisGenerator.destroy();
    }
}
