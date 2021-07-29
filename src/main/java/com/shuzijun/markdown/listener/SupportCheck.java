package com.shuzijun.markdown.listener;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.startup.StartupActivity;
import com.intellij.ui.jcef.JBCefApp;
import com.shuzijun.markdown.model.PluginConstant;
import org.jetbrains.annotations.NotNull;

/**
 * @author shuzijun
 */
public class SupportCheck implements StartupActivity, DumbAware {

    public static boolean isFirstProject = true;

    @Override
    public void runActivity(@NotNull Project project) {
        if (ApplicationManager.getApplication().isUnitTestMode() ||  !isFirstProject ) {
            return;
        }
        if(!JBCefApp.isSupported()){
            Notifications.Bus.notify(new Notification(PluginConstant.NOTIFICATION_GROUP, "Not Support JCEF", "Your environment does not support JCEF, cannot use Markdown Editor", NotificationType.ERROR));
        }
    }
}
