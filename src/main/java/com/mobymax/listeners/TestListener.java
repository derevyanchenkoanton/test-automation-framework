package com.mobymax.listeners;

import com.mobymax.utils.AllureUtils;
import com.mobymax.utils.TestReflectionUtil;
import com.mobymax.utils.TestResultStatusCollector;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import static java.util.Objects.nonNull;

public class TestListener implements IInvokedMethodListener {
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            int testId = TestReflectionUtil.getTestId(method);
            if (nonNull(testResult.getThrowable())) {
                TestResultStatusCollector.addResult(testId, TestResultStatusCollector.TestStatus.FAILED);
            } else {
                TestResultStatusCollector.addResult(testId, TestResultStatusCollector.TestStatus.PASSED);
            }
            AllureUtils.takeScreenshot(testResult.getMethod().getMethodName());
        }
    }
}
