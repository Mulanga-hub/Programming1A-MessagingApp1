#!/usr/bin/env python3
"""
Simple Messaging Application
Allows users to save, receive (list), and delete messages.
Messages are stored in a text file.
"""

import os

MESSAGES_FILE = "messages.txt"

def load_messages():
    """Load messages from file."""
    if not os.path.exists(MESSAGES_FILE):
        return []
    with open(MESSAGES_FILE, 'r') as f:
        return [line.strip() for line in f if line.strip()]

def save_messages(messages):
    """Save messages to file."""
    with open(MESSAGES_FILE, 'w') as f:
        for msg in messages:
            f.write(msg + '\n')

def save_message(message):
    """Save a new message."""
    messages = load_messages()
    messages.append(message)
    save_messages(messages)
    print("Message saved!")

def receive_messages():
    """List all messages."""
    messages = load_messages()
    if not messages:
        print("No messages.")
        return
    print("Messages:")
    for i, msg in enumerate(messages, 1):
        print(f"{i}. {msg}")

def delete_message(index):
    """Delete a message by index."""
    messages = load_messages()
    if 1 <= index <= len(messages):
        deleted = messages.pop(index - 1)
        save_messages(messages)
        print(f"Deleted: {deleted}")
    else:
        print("Invalid index.")

def main():
    while True:
        print("\nMessaging App")
        print("1. Save message")
        print("2. Receive messages")
        print("3. Delete message")
        print("4. Exit")
        choice = input("Choose an option: ").strip()

        if choice == '1':
            message = input("Enter message: ").strip()
            if message:
                save_message(message)
            else:
                print("Message cannot be empty.")
        elif choice == '2':
            receive_messages()
        elif choice == '3':
            try:
                index = int(input("Enter message number to delete: ").strip())
                delete_message(index)
            except ValueError:
                print("Invalid number.")
        elif choice == '4':
            break
        else:
            print("Invalid choice.")

if __name__ == "__main__":
    main()