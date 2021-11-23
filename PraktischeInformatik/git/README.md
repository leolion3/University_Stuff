# Git

## Wtf ist git?

To quote Wikipedia (yes it's no scientific source, gimme a break): "Git is software for tracking changes in any set of files, usually used for coordinating work among programmers collaboratively developing source code during software development. Its goals include speed, data integrity, and support for distributed, non-linear workflows."

## Ok... what does this mean for me?

When working on a project together, sending files back and forth using Whatsapp or whatever is not just a hustle but unscalable with very large projects - thats where git comes in handy.
Git tracks all the changes you (and other devs) have done on a project and attempts to merge (join) these changes together when you upload your changes.

## You said upload, where to?

Git works with Git Repositories. For the sake of simplicity, we will say that a git repository is just a "Storage device in the cloud" that has a log of all changes that each developer has published (e.g. like a file manager that knows when which files were created, changed, deleted, etc.).

Popular platforms for hosting git repositories include Github (now owned by Microsoft) and Gitlab.

## SSH vs Https

When working with remote git repositories, one can either use SSH oder Https to authenticate with the remote hosting provider (the one hosting the repositories).
Https uses Username-Password authentication while SSH uses Public-Private key authentication.

### Public-Private key authentication

In a Public/Private key architecture the public key is used to encrypt information and the private key is used to decrypt information. This works thanks to some very fancy mathematics that I will not discuss here.

When authenticating with a remote server you and the remote server know each others Public keys and use these to establish a TLS Tunnel (a secure encrypted tunnel) to exchange information.

The Public key may be shared publicly, the private key, however, **must never be shared**.  

Many people prefer SSH over Https, both because it can be more secure (depending on your password strength and many other factors) and because its much less of a hustle to work with.

### Generating an SSH Keypair

- To use SSH instead of Https, launch a terminal of your choice (on Windows the Windows Terminal is excellent, powershell is fine and cmd is crap to work with) and then enter the command

```bash
ssh-keygen -t rsa -b 4096
```

This will launch the *ssh-keygen* application and provide it the parameters *-t rsa* for "type: RSA" and *-b 4096* for specifying that the key should be 4096 Bits long. The number can be replace by any number greater than 2048, however the bigger the number the more secure it is. **1024 should not be used anymore** as it has theoretically been proven to be insecure.  

If you want to know what RSA means, please take the time to read up on the RSA Algorithm.

- After entering the command it will ask you where you would like to save your key (and it will show you the default path "~/.ssh/"), you **do not want to change this unless you know what you are doing**, in which case you would probably not be reading this article. Just hit enter without entering anything.

- It will then ask you to enter a password for your key. You can leave this field blank, it will however be less secure as anyone with your private key will be able to immitate you.

After entering a passphrase it will take a couple seconds to generate the key (on slow systems), and will then print out the key's randomart.

### Adding SSH Public key to Gitlab/Github

Now to add your key to Gitlab/Github (the process is identical), you want to first copy your public key.

- To do this, enter the following command (also works on Windows using WT oder powershell):

```bash
cat ~~/.ssh/id_rsa.pub
```

Notice the ".pub" following the filename? That indicates its the public key. The private key is stored by default in "~/.ssh/id_rsa". 

This will print out the key. You want to highlight it from the first "-" before "BEGIN RSA PUBLIC KEY" and up until the last "-" after "END RSA PUBLIC KEY" and copy it (in WT/Powershell using the right click mouse button copies whatever text it highlighted to the clipboard).

- Navigate onto Github and go to your account settings. Click on "SSH and GPG Keys" and under "SSH Keys" click on "New SSH Key".

- Leave the Title empty for now and paste your key under "Key" into the input box. The title will be set automatically, you can however change this to whatever you want. The only use of the title is for you to be able to distinguish your different keys.

## How does git work? (Oversimplified)

We will use a simple work-life-analogy to demonstrate how git works.

### Remote repository

Consider yourself working in an office. Your archiving department has a cardboard box containing a projects papers (A4 papers), this box containing the "original" documents is the "remote repository" (hosted on Github/Gitlab).

### Cloning and local repository

When you "clone" a repository, you are basically going into your boss' office, taking his papers, copying them and putting the copies into your own cardboard box. Your own cardboard box is your "local repository" - the one that exists on your own system. 

To clone a repository we use the 

```bash
git clone /link/to/repository
```

command.

### Git Add

For you to work on your papers you need to take them out of the box. When the papers have been changed, you put them back in the box. This is identical to using the

```bash
git add fileName
```

command, with which you add your changed files to a "commit".

### Git Commit

When you commit your changes you are basically taking your box (with all the new changes), closing it with a lid and adding a label on top with a "commit message" of your choice (it should correspond to whatever you have done, be short but precise) for the archiving department. The commit will contain a "label" which is auto-generated (in our analogy by the label printer) and used to distinguish different commits. 

Doing this is identical to using the command

```bash
git commit -m "commit message"
```

There are more ways of doing this:

```bash
git commit -a # -> opens whatever text editor was assigned to be used with git, the message can be entered inside the text editor and when the file is saved the message is applied
git commit --amend # Identical to -a
git commit --message "commit message" # Identical to -m
```

### Git Push and Conflicts

When pushing your changes, you are taking your closed box and handing to to the workers at the archiving department, who will attempt to add your changes to the original papers in the remote repository. He will check whatever changes you have made and append them to the remote files. If you have shredded any of your papers (deleted files), he will proceed to shred the ones he has, and if you have added any papers he will copy them and add them to his own box.

This is identical to using the command 

```bash
git push
```

Sometimes the archiving department receives multiple boxes that have changed the same paper at the same spots (same file and same lines, for instance in a java file). This will result in what we call a "Conflict".

The changes of your co-worker have already been applied since he came in first, so now the archiving worker asks you to "fix the conflicts". This means you open your box and the archiving departments one, compare the two files and choose which changes should be kept and which should be discarded. Once the conflicts have been fixed, another commit is created (with your box) with a label saying that the conflicts have been resolved. This commit contains the newest version of the documents and will overwrite whatever is present in the archiving department's box.

### Git Pull

To fetch whatever changes have happened to the original documents, you ask an archiving department worker to hand you copies of whatever files have changed so you may add them to your own box. Doing this may result in conflicts that need to be resolved.

To do this, use the command

```bash
git pull
``` 

### Git Fetch

To fetch the remote changes without actually updating your own documents (e.g. you know what changed but your files are still old), use the command

```bash
git fetch
```

### Branches

What if you are asked to work on a side project without changing the archiving department's documents? This is where branches come in.

Creating a new branch is identical to asking the archiving department to create a new box (your branch on the remote repository) with a given label. Now, whenever you change your files, you no longer join them with the original documents, but rather with your box in the archiving department (note that you still work on your own copy of the documents and push your changes to the archiving department).

To create a new branch, use the command

```bash
git checkout -b newBranchName
```

With the **checkout** command you can checkout files (if you want to discard changes in a given file for instance) and swap the current working branch.

The "-b" symbolises that you wish to create a new branch using your current changes (even uncommitted). The "newBranchName" is the label your branch will have.

**Note:** Even though you have changed the branch locally, the remote doesn't know that this branch exists (because git on your system does not automatically synchronise with the remote server, unlike tools like SVN). 

To publish your branch on the remote, enter the command

```bash
git push --set-upstream origin newBranchName
```

This will add the new branch to the remote and push your current changes to it.

- To see a list of available branches, use the command

```bash
git branch
```

- To delete a branch, use the command

```bash
git branch --delte branchName
```

- To switch to a branch, use the command

```bash
git checkout branchName
```

### Merging branches

When you and your co-workers are working on implementing different features you will often be working on different branches. You can however join your changes with that of a colleague. To do this, switch to whatever branch you want your colleagues changes to be joined with (**your branch** will receive **their changes**) and use the command

```bash
git merge otherBranchName
```  

This may result in conflicts, which will need to be resolved.

### Pull Requests

In a normal office environment you will normally never push your changes directly to the "master" (newly called "main" branch), so that you don't break a working software by pushing buggy code. Rather, you will be working on your own branch to implement a given feature. 

When your branch has the feature ready, in order to publish the feature to the working software, your branch will need to me merged onto the main branch. This is done by creating a "pull-request". **Note** that it is possible to switch to the main branch and use the merge command mentioned previously to add the changes onto the main branch, this however does not work in corporate projects as the main branch is often "protected" - which means it cannot be directly modified.

When creating a pull-request you are notifying your superiors that a change is ready to be joined onto the main branch. Workers assigned to evaluate your code will review whaever changes you have made and add their opinions on things that you should change. After changing everything accordingly an authorised worker will merge your branch onto the main branch, bringing the feature to life in the production software. 

## Conclusion

This was a quick walkthrough of some of the features git has to offer. Git is a very mighty tool if used appropriately and an essential tool every developer should know.