import './footerStyles.scss'
import { BsLinkedin } from 'react-icons/bs'

const Footer = () => {
  return (
    <footer className='footer'>
        <a
            className='footer_link'
            href='https://www.linkedin.com/in/gustavo-oscar-starace-enjamio/'
            target='__blank'
            rel="noopener noreferrer"
        >
            <BsLinkedin size={30} />
            <span>Gustavo Starace</span>
        </a>
        <a
            className='footer_link'
            href='https://www.linkedin.com/in/francisco-gonzalez-web-dev/'
            target='__blank'
            rel="noopener noreferrer"
        >
            <BsLinkedin size={30} />
            <span>Francisco Gonzalez</span>
        </a>
    </footer>
  )
}

export default Footer