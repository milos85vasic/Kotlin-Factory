# Kotlin Factory
Simple wizard for creating Kotlin Gradle projects.

## Usage
```
java -jar KotlinFactory.jar ~/some_configuration.json
```
Configuration passed as json must be configured according the following template example:
```json
{
  "language": {
    "name": "kotlin",
    "version": "1.1.1"
  },
  "name": "My example project",
  "modules": [
    {
      "name": "Example module 1",
      "version": {
        "alpha": 0,
        "beta": 0,
        "primary": 1,
        "secondary": 0,
        "tertiary": 0
      },
      "group": "example_module_1",
      "package": "net.milosvasic.tryout.factory.kotlin",
      "plugins": {
        "collection": [
          {
            "name": "maven-deploy"
          },
          {
            "name": "or-else"
          }
        ]
      }
    },
    {
      "name": "Example module 2",
      "version": {
        "alpha": 0,
        "beta": 0,
        "primary": 1,
        "secondary": 0,
        "tertiary": 0
      },
      "group": "example_module_2",
      "package": "net.milosvasic.tryout.factory.kotlin"
    },
    {
      "name": "Example application module",
      "version": {
        "alpha": 0,
        "beta": 0,
        "primary": 1,
        "secondary": 0,
        "tertiary": 0
      },
      "isApplication": true,
      "group": "example_module_3",
      "package": "net.milosvasic.tryout.factory.kotlin",
      "credentials": [
        {
          "name": "default",
          "ftp": {
            "server": "special.example.com",
            "username": "special1",
            "password": "special1"
          }
        },
        {
          "name": "development",
          "ftp": {
            "server": "special.example.com",
            "username": "special1",
            "password": "special1"
          }
        },
        {
          "name": "production",
          "ftp": {
            "server": "special2.example.com",
            "username": "special2",
            "password": "special2"
          }
        }
      ]
    }
  ],
  "credentials": [
    {
      "name": "default",
      "ftp": {
        "server": "repo.other.com",
        "username": "something",
        "password": "something"
      }
    },
    {
      "name": "development",
      "ftp": {
        "server": "repo.something.other.net",
        "username": "username@something",
        "password": "some_pass"
      }
    },
    {
      "name": "production",
      "ftp": {
        "server": "repo.something.else.net",
        "username": "user",
        "password": "pass"
      }
    }
  ]
}
```
To support git repository add the following into project object with proper data:
```json
{
  "git": {
    "cloneUrl": "https://user@github.com/some_user/example_repo.git"
  }
}
```
NOTE: Git functionality is intended to be used with plain repo that waits for it's first initial project commit.
If repo is not empty, since we will clone it, it may happen some conflicts to occur. 
