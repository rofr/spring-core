

 * The Spring container is a DI Container, aka IoC Container
 * The container contains beans
 * The container is managed by the context
 * The context implements ApplicationContext, BeanFactory and lots of other interfaces
   
   3 ways to define beans:
      * xml files
	  * Annotations
	  * Java configuration
	  
	  @Configuration	Applies to a java configuration class
	  @Bean			Methods of the java configuration class that provide beans
	  @ComponentScan	applied to the config class, scans the current package
	  
	  @Component		Apply to a class and it will be registered during a component scan
						
	  @Service, @Controller, @Repository are all special kinds of @Component
	  
	  @Scope	Default is "singleton"
	  @Primary	Denotes the default bean when there are multiple beans that could satisfy a dependency.
	  
	  @PostConstruct	The context calls this method just after dependencies have been wired
	  @PreDestroy		The context calls this method just before a bean goes out of scope
	  
	  @Autowired	Tells the context that a field, method or constructor should be set/called