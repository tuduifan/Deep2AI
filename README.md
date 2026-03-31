# Deep2AI
train

1.GIT学习
$ mkdir learngit
$ cd learngit
$ pwd
$ git init
$ git add readme.txt
$ git commit -m "wrote a readme file"
$ git status
$ 内容差异 git diff 或者看某个文件： git diff readme.txt
$ 历史记录 git log  或输出更简洁的: $ git log --pretty=oneline
$ 回退历史版本 git reset --hard HEAD^ （HEAD当前版本，HEAD^上一版本，HEAD^^上上版本，HEAD~100上100版）
$ cat readme.txt
$ git reset --hard 1094a（如果被回退的版本的版本号commit id还能在命令行窗口中找到就用版本号回退，版本号可用前几位）
$ git reflog 记录了每一次的commit id可用于回退任何版本）
$ 