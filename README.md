# Integrating Git Bash with GitHub

This guide provides step-by-step instructions for integrating Git Bash with GitHub, setting up SSH authentication, and pushing changes to a GitHub repository.

## Prerequisites
- Git Bash installed on your computer
- A GitHub account

## Steps

### 1. Configure Git with Your GitHub Information

Open Git Bash and run the following commands to configure your Git username and email:

```bash
git config --global user.name "Your Name"
git config --global user.email "your_email@example.com"

2.Generate an SSH Key
Generate an SSH key to use for authentication with GitHub:

bash
Copy code
ssh-keygen -t rsa -b 4096 -C "your_email@example.com"

3. Start the SSH Agent and Add Your Key
Start the SSH agent and add your SSH key:

bash
Copy code
eval $(ssh-agent -s)
ssh-add ~/.ssh/id_rsa

4. Add Your SSH Key to Your GitHub Account
Copy the SSH public key to your clipboard:

bash
Copy code
cat ~/.ssh/id_rsa.pub
Go to GitHub and log in to your account.

Click on your profile icon in the top-right corner and select Settings.

In the left sidebar, click SSH and GPG keys.

Click the New SSH key button.

Give your key a descriptive title, paste the SSH key into the "Key" field, and click Add SSH key.
5. Verify SSH Connection
Verify that your SSH key is correctly set up and can connect to GitHub:

bash
Copy code
ssh -T git@github.com
You should see a message like "Hi username! You've successfully authenticated, but GitHub does not provide shell access."
