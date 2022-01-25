import org.apache.maven.model.Plugin;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.util.List;

@Mojo(name = "sbermojo")
public class TestMojo extends AbstractMojo {

    @Parameter(defaultValue = "${project}", required = true, readonly = true)
    private MavenProject project;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        List<Plugin> plugins = project.getBuildPlugins();
        plugins.forEach(plugin -> {
            if (plugin.getArtifactId().equals("maven-checkstyle-plugin")) {
                System.out.println("Плагин подключен");
                System.out.println(plugin.getVersion());
                System.out.println(plugin.getConfiguration());
            }
        });
    }
}
