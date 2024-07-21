package org.eclipse.jakarta.hello.configs.events;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import org.eclipse.jakarta.hello.configs.annotations.Timed;

// Define this as an interceptor linked to our timed annotation
@Interceptor
@Timed
public class TimedInterceptor {

    /**
     * The business logic we want to apply to our @Timed annotation
     * @param ctx tells us on which method we are intercepting
     * @return A custom message for the user, telling the execution time of the method
     */
    @AroundInvoke // since we can have many methods being intercepted, we use this annotation
    public Object timeInvocation(InvocationContext ctx) throws Exception {
        // Before method execution
        long startTime = System.currentTimeMillis();

        // create a 1sec timeout
        Thread.sleep(1000);

        Object result =  ctx.proceed();

        // After method execution
        long endTime = System.currentTimeMillis();

        return result + " took " + (endTime - startTime) + "ms to execute";
    }
}
