/*
 * Copyright 2019. the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ecfront.dew.common;

/**
 * DEW Common 操作入口.
 *
 * @author gudaoxuri
 */
public class $ {

    /**
     * Json与Java对象互转.
     */
    public static JsonHelper json = JsonHelper.pick("");

    /**
     * Json与Java对象互转.
     * <p>
     * 使用自定义实例ID（用于支持不同Json配置）
     */
    public static JsonHelper json(String instanceId) {
        assert instanceId != null && !instanceId.trim().equals("");
        return JsonHelper.pick(instanceId);
    }

    /**
     * Java Bean操作.
     */
    public static BeanHelper bean = new BeanHelper();

    /**
     * Java Bean操作.
     *
     * @param useCache 是否启用缓存，启用后会缓存获取过的字段和方法列表，默认启用
     */
    public static BeanHelper bean(boolean useCache) {
        return new BeanHelper(useCache);
    }

    ;

    /**
     * Java Class扫描操作.
     */
    public static ClassScanHelper clazz = new ClassScanHelper();

    /**
     * 安全（加解密、信息摘要等）操作.
     */
    public static SecurityHelper security = new SecurityHelper();

    /**
     * 常用字段操作.
     */
    public static FieldHelper field = new FieldHelper();

    /**
     * 常用文件操作.
     */
    public static FileHelper file = new FileHelper();

    /**
     * MIME信息操作.
     */
    public static MimeHelper mime = new MimeHelper();

    /**
     * 时间操作.
     */
    public static TimeHelper time() {
        return new TimeHelper();
    }

    /**
     * 定时器操作.
     */
    public static TimerHelper timer = new TimerHelper();

    /**
     * Shell脚本操作.
     */
    public static ShellHelper shell = new ShellHelper();

    /**
     * 拦截器栈执行器.
     */
    public static InterceptorHelper interceptor = new InterceptorHelper();

    /**
     * Http操作.
     */
    public static HttpHelper http = HttpHelperFactory.choose();

    /**
     * Http操作.
     *
     * @param maxTotal                整个连接池最大连接数
     * @param maxPerRoute             每个路由（域）的默认最大连接
     * @param defaultConnectTimeoutMS 默认连接超时时间
     * @param defaultSocketTimeoutMS  默认读取超时时间
     * @param autoRedirect            302状态下是否自动跳转
     * @param retryAble               是否重试
     */
    public static HttpHelper http(int maxTotal, int maxPerRoute,
                                  int defaultConnectTimeoutMS, int defaultSocketTimeoutMS,
                                  boolean autoRedirect, boolean retryAble) {
        return HttpHelperFactory.choose(maxTotal, maxPerRoute, defaultConnectTimeoutMS, defaultSocketTimeoutMS,
                autoRedirect, retryAble);
    }

    /**
     * 金额操作.
     */
    public static AmountHelper amount = new AmountHelper();

    /**
     * 函数操作.
     */
    public static FunctionHelper fun = new FunctionHelper();

    /**
     * 简单的降级处理.
     */
    public static FallbackHelper fallback = new FallbackHelper();

    /**
     * 脚本处理.
     * <p>
     * 包含预编译，适用于脚本复用性的场景
     *
     * @param jsFunsCode    JS 脚本
     * @param addCommonCode 是否添加dew-common包到脚本
     */
    public static ScriptHelper script(String jsFunsCode, boolean addCommonCode) {
        return ScriptHelper.build(jsFunsCode, addCommonCode);
    }

    /**
     * 脚本处理.
     * <p>
     * 包含预编译，适用于脚本复用性的场景，默认添加dew-common包到脚本
     *
     * @param jsFunsCode JS 脚本
     */
    public static ScriptHelper script(String jsFunsCode) {
        return ScriptHelper.build(jsFunsCode, true);
    }

    /**
     * 脚本处理.
     * <p>
     * 适用于简单的脚本的执行
     *
     * @param jsCode JS 脚本
     */
    public static Object eval(String jsCode) {
        return ScriptHelper.eval(jsCode);
    }

}
