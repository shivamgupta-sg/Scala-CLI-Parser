# Scala CLI Parser

A command-line utility to print a message using scala.

```
Usage: cliparser options [message]

Options:
print      Prints the message.
version    Get the version of the application.
help       Prints the flags descriptions.
```
## Commands
### 1. print: Prints the message.

Examples
```shell
> cliparser --print Welcome
WELCOME
```

### 2. version: Gives the version of the application.

Example
```shell
> cliparser --version
Version : 0.1

```

### 3. help: Gives flags descriptions.

Example
```shell
> cliparser --help
Usage: cliparser options [message]

Options:
print      Prints the message.
version    Get the version of the application.
help       Prints the flags descriptions.

```
