# Java-jooq
	<plugin>
				<groupId>org.jooq</groupId>
				<artifactId>jooq-codegen-maven</artifactId>
				<!-- The plugin should hook into the generate goal -->
				<executions>
					<execution>
						<goals>
							<goal>generate</goal>
						</goals>
					</execution>
				</executions>
				<!-- Manage the plugin's dependency. In this example, we'll use a PostgreSQL database -->
				<dependencies>
					<dependency>
						<groupId>org.postgresql</groupId>
						<artifactId>postgresql</artifactId>
						<version>9.4.1212</version>
					</dependency>
				</dependencies>

				<!-- Specify the plugin configuration.
                     The configuration format is the same as for the standalone code generator -->
				<configuration>

					<!-- JDBC connection parameters -->
					<jdbc>
						<driver>org.postgresql.Driver</driver>
						<url>jdbc:postgresql:jooqdb</url>
						<user>jooq</user>
						<password>jooq</password>
					</jdbc>

					<!-- Generator parameters -->
					<generator>
						<database>
							<name>org.jooq.meta.postgres.PostgresDatabase</name>
							<includes>.*</includes>
							<excludes></excludes>
							<!-- In case your database supports catalogs, e.g. SQL Server:
                            <inputCatalog>public</inputCatalog>
                              -->
							<inputSchema>public</inputSchema>
							<properties>
								<property>
									<key>scripts</key>
									<value>src/main/resources/flyway/schema/**/*.sql</value>
								</property>
							</properties>
						</database>
						<target>
							<packageName>org.jooq.codegen.maven.example</packageName>
							<directory>src/main/java/com/eburtis/learnjooqs/domain/generated/jooq</directory>
						</target>
					</generator>
				</configuration>
			</plugin>
